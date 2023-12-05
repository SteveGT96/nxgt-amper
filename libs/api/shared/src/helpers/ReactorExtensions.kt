package helpers

import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.reactive.*
import kotlinx.coroutines.reactor.awaitSingleOrNull
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

suspend fun <T> Mono<T>.first(): T = awaitFirst()
suspend fun <T> Mono<T>.firstOrNull(): T? = awaitFirstOrNull()
suspend fun <T> Mono<T>.firstOrDefault(default: T): T = awaitFirstOrDefault(default)
suspend fun <T> Mono<T>.last(): T = awaitLast()
suspend fun <T> Mono<T>.single(): T = awaitSingle()
suspend fun <T> Mono<T>.singleOrNull(): T? = awaitSingleOrNull()

suspend fun <T> Flux<T>.first(): T = awaitFirst()
suspend fun <T> Flux<T>.firstOrNull(): T? = awaitFirstOrNull()
suspend fun <T> Flux<T>.firstOrDefault(default: T): T = awaitFirstOrDefault(default)
suspend fun <T> Flux<T>.last(): T = awaitLast()
suspend fun <T> Flux<T>.single(): T = awaitSingle()
suspend fun <T> Flux<T>.toList(): List<T> = awaitAll()

