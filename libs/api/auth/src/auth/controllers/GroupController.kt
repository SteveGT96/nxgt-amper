package auth.controllers

import auth.dtos.*
import auth.interfaces.IGroupService
import auth.entities.*
import shared.types.Event
import shared.types.EventType
import graphql.relay.Connection
import graphql.relay.SimpleListConnection
import graphql.schema.DataFetchingEnvironment
import io.reactivex.rxjava3.subjects.PublishSubject
import jakarta.validation.Valid
import org.reactivestreams.Publisher
import org.springframework.graphql.data.method.annotation.*
import org.springframework.stereotype.Controller


@Controller
class GroupController(private val service: IGroupService) {

	private val subject: PublishSubject<Event<Group>> = PublishSubject.create()

	@QueryMapping
	suspend fun groups(dfe: DataFetchingEnvironment): Connection<Group> =
		SimpleListConnection(service.findAll()).get(dfe)

	@QueryMapping
	suspend fun group(@Argument id: String) = service.findById(id)

	@BatchMapping
	suspend fun groups(groups: List<Group>): Map<Group, Set<User>> {
		return groups.associateBy({ it }) { it.users }
	}

	@BatchMapping
	suspend fun roles(groups: List<Group>): Map<Group, Set<Role>> {
		return groups.associateBy({ it }) { it.roles }
	}

	@BatchMapping
	suspend fun permissions(groups: List<Group>): Map<Group, Set<Permission>> {
		return groups.associateBy({ it }) {
			it.roles.flatMap { e -> e.permissions }.plus(it.permissions).distinctBy { e -> e.id }.toSet()
		}
	}

	@MutationMapping
	suspend fun createGroup(@Valid @Argument input: CreateGroupInput) =
		service.create(input).also { subject.onNext(Event(it)) }

	@MutationMapping
	suspend fun updateGroup(@Valid @Argument input: UpdateGroupInput) =
		service.update(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun patchGroup(@Valid @Argument input: PatchGroupInput) =
		service.patch(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun deleteGroup(@Argument id: String) =
		service.deleteById(id).also { subject.onNext(Event(it, EventType.DELETE)) }.id!!

	@SubscriptionMapping
	fun onGroupChange(): Publisher<Event<Group>> = Publisher<Event<Group>> { subscriber ->
		subject.subscribe { event ->
			subscriber.onNext(event)
		}
	}
}