package auth.controllers

import auth.dto.*
import auth.interfaces.IPermissionService
import auth.models.Permission
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
class PermissionController(private val service: IPermissionService) {

	private val subject: PublishSubject<Event<Permission>> = PublishSubject.create()

	@QueryMapping
	suspend fun permissions(dfe: DataFetchingEnvironment): Connection<Permission> =
		SimpleListConnection(service.findAll()).get(dfe)

	@QueryMapping
	suspend fun permission(@Argument id: String) = service.findById(id)

	@MutationMapping
	suspend fun createPermission(@Valid @Argument input: CreatePermissionInput) =
		service.create(input).also { subject.onNext(Event(it)) }

	@MutationMapping
	suspend fun updatePermission(@Valid @Argument input: UpdatePermissionInput) =
		service.update(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun patchPermission(@Valid @Argument input: PatchPermissionInput) =
		service.patch(input).also { subject.onNext(Event(it, EventType.UPDATE)) }

	@MutationMapping
	suspend fun deletePermission(@Argument id: String) =
		service.deleteById(id).also { subject.onNext(Event(it, EventType.DELETE)) }.id!!

	@SubscriptionMapping
	fun onPermissionChange(): Publisher<Event<Permission>> = Publisher<Event<Permission>> { subscriber ->
		subject.subscribe { event ->
			subscriber.onNext(event)
		}
	}
}