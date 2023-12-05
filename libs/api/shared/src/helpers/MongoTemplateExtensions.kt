package helpers

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.*

/**
 * Finds all documents of the given type where the value of the given field is equal to one of the given values.
 *
 * @param key The name of the field to query.
 * @param values The list of values to match.
 * @return A list of all documents that match the query.
 */
inline fun <reified T : Any> MongoTemplate.findByKeyIn(key: String, values: List<Any>) =
	find<T>(Query.query(Criteria.where(key).`in`(values)))

/**
 * Finds all documents of the given type where the value of the given field is equal to one of the given values.
 *
 * @param key The name of the field to query.
 * @param values The set of values to match.
 * @return A list of all documents that match the query.
 */
inline fun <reified T : Any> MongoTemplate.findByKeyIn(key: String, values: Set<Any>) =
	find<T>(Query.query(Criteria.where(key).`in`(values)))

/**
 * Combines multiple update functions into a single update function.
 *
 * @param updates The update functions to combine.
 * @return A single update function that combines the functionality of all the given update functions.
 */
fun combine(vararg updates: (Update) -> Update): Update {
	return updates.fold(Update()) { acc, function -> function(acc) }
}