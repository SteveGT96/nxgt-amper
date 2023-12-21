package auth.controllers

import auth.dtos.*
import auth.helpers.*
import auth.interfaces.IUserService
import auth.entities.*
import shared.types.Event
import shared.types.EventType
import graphql.relay.Connection
import graphql.relay.SimpleListConnection
import graphql.schema.DataFetchingEnvironment
import io.reactivex.rxjava3.subjects.PublishSubject
import jakarta.validation.Valid
import org.reactivestreams.Publisher
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.graphql.data.method.annotation.*
import org.springframework.stereotype.Controller


@Controller
class UserController(private val service: IUserService, private val template: MongoTemplate) {

	private val subject: PublishSubject<Event<User>> = PublishSubject.create()

	@QueryMapping
	suspend fun users(dfe: DataFetchingEnvironment): Connection<User> = SimpleListConnection(service.findAll()).get(dfe)

	@QueryMapping
	suspend fun user(@Argument id: String) = service.findById(id)

	@QueryMapping
	suspend fun profile() = currentUser.requiredValue.user

	@BatchMapping
	suspend fun groups(users: List<User>): Map<User, Set<Group>> {
		return users.associateBy({ it }) { it.loadGroups(template) }
	}

	@BatchMapping
	suspend fun roles(users: List<User>): Map<User, Set<Role>> {
		return users.associateBy({ it }) { it.loadRoles(template) }
	}

	@BatchMapping
	suspend fun permissions(users: List<User>): Map<User, Set<Permission>> {
		return users.associateBy({ it }) { it.loadPermissions(template) }
	}

	@MutationMapping
	suspend fun createUser(@Valid @Argument input: CreateUserInput) =
		service.create(input).also { subject.onNext(Event(it)) }

	@MutationMapping
	suspend fun createUserAccount(@Valid @Argument input: CreateAccountInput) =
		service.createAccount(input).also { subject.onNext(Event(it)) }

	@MutationMapping
	suspend fun updateUser(@Valid @Argument input: UpdateUserInput) =
		service.update(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun patchUser(@Valid @Argument input: PatchUserInput) =
		service.patch(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun deleteUser(@Argument id: String) =
		service.deleteById(id).also { subject.onNext(Event(it, EventType.DELETE)) }.id!!

	@SubscriptionMapping
	fun onUserChange(): Publisher<Event<User>> = Publisher<Event<User>> { subscriber ->
		subject.subscribe { event ->
			subscriber.onNext(event)
		}
	}
}