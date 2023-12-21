package auth.controllers

import auth.dtos.*
import auth.interfaces.IRoleService
import auth.entities.Permission
import auth.entities.Role
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
class RoleController(private val service: IRoleService) {

	private val subject: PublishSubject<Event<Role>> = PublishSubject.create()

	@QueryMapping
	suspend fun roles(dfe: DataFetchingEnvironment): Connection<Role> = SimpleListConnection(service.findAll()).get(dfe)

	@QueryMapping("role")
	suspend fun role(@Argument id: String) = service.findById(id)

	@BatchMapping
	suspend fun permissions(roles: List<Role>): Map<Role, Set<Permission>> {
		return roles.associateBy({ it }) { it.permissions }
	}

	@MutationMapping
	suspend fun createRole(@Valid @Argument input: CreateRoleInput) =
		service.create(input).also { subject.onNext(Event(it)) }

	@MutationMapping
	suspend fun updateRole(@Valid @Argument input: UpdateRoleInput) =
		service.update(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun patchRole(@Valid @Argument input: PatchRoleInput) =
		service.patch(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun deleteRole(@Argument id: String) =
		service.deleteById(id).also { subject.onNext(Event(it, EventType.DELETE)) }.id!!

	@SubscriptionMapping
	fun onRoleChange(): Publisher<Event<Role>> = Publisher<Event<Role>> { subscriber ->
		subject.subscribe { event ->
			subscriber.onNext(event)
		}
	}
}