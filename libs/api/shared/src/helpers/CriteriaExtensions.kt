package helpers

import org.springframework.data.geo.*
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query
import java.util.regex.Pattern
import kotlin.reflect.KProperty

/**
 * Gets a query object from the current Criteria object.
 *
 * @return A query object.
 */
val Criteria.query
	get() = query(this)

/**
 * Creates a new Criteria object that matches the logical OR of the given criteria.
 *
 * @param criteria The criteria to OR together.
 * @return A new Criteria object that matches the logical OR of the given criteria.
 */
fun or(vararg criteria: Criteria) = Criteria().orOperator(*criteria)

/**
 * Creates a new Criteria object that matches the logical NOR of the given criteria.
 *
 * @param criteria The criteria to NOR together.
 * @return A new Criteria object that matches the logical NOR of the given criteria.
 */
fun nor(vararg criteria: Criteria) = Criteria().norOperator(*criteria)

/**
 * Creates a new Criteria object that matches the logical AND of the given criteria.
 *
 * @param criteria The criteria to AND together.
 * @return A new Criteria object that matches the logical AND of the given criteria.
 */
fun and(vararg criteria: Criteria) = Criteria().andOperator(*criteria)

/**
 * Creates a new Criteria object that matches the given field being equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field being equal to the given value.
 */
infix fun String.`is`(value: Any?) = where(this).`is`(value)

/**
 * Creates a new Criteria object that matches the given KProperty being equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty being equal to the given value.
 */
infix fun KProperty<*>.`is`(value: Any?) = where(this.snakeName).`is`(value)

/**
 * Creates a new Criteria object that matches the given field being equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field being equal to the given value.
 */
infix fun String.eq(value: Any?) = `is`(value)

/**
 * Creates a new Criteria object that matches the given KProperty being equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty being equal to the given value.
 */
infix fun KProperty<*>.eq(value: Any?) = `is`(value)

/**
 * Creates a new Criteria object that matches the given field not being equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field not being equal to the given value.
 */
infix fun String.ne(value: Any?) = where(this).ne(value)

/**
 * Creates a new Criteria object that matches the given KProperty not being equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty not being equal to the given value.
 */
infix fun KProperty<*>.ne(value: Any?) = where(this.snakeName).ne(value)

/**
 * Creates a new Criteria object that matches the given field being less than the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field being less than the given value.
 */
infix fun String.lt(value: Any) = where(this).lt(value)

/**
 * Creates a new Criteria object that matches the given KProperty being less than the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty being less than the given value.
 */
infix fun KProperty<*>.lt(value: Any) = where(this.snakeName).lt(value)

/**
 * Creates a new Criteria object that matches the given field being less than or equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field being less than or equal to the given value.
 */
infix fun String.lte(value: Any) = where(this).lte(value)

/**
 * Creates a new Criteria object that matches the given KProperty being less than or equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty being less than or equal to the given value.
 */
infix fun KProperty<*>.lte(value: Any) = where(this.snakeName).lte(value)

/**
 * Creates a new Criteria object that matches the given field being greater than the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field being greater than the given value.
 */
infix fun String.gt(value: Any) = where(this).gt(value)

/**
 * Creates a new Criteria object that matches the given KProperty being greater than the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty being greater than the given value.
 */
infix fun KProperty<*>.gt(value: Any) = where(this.snakeName).gt(value)

/**
 * Creates a new Criteria object that matches the given field being greater than or equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given field being greater than or equal to the given value.
 */
infix fun String.gte(value: Any) = where(this).gte(value)

/**
 * Creates a new Criteria object that matches the given KProperty being greater than or equal to the given value.
 *
 * @param value The value to match.
 * @return A new Criteria object that matches the given KProperty being greater than or equal to the given value.
 */
infix fun KProperty<*>.gte(value: Any) = where(this.snakeName).gte(value)

/**
 * Creates a new Criteria object that matches the given field being an embedded document that matches the given criteria.
 *
 * @param value The criteria that the embedded document must match.
 * @return A new Criteria object that matches the given field being an embedded document that matches the given criteria.
 */
infix fun String.elemMatch(value: Criteria) = where(this).elemMatch(value)

/**
 * Creates a new Criteria object that matches the given KProperty being an embedded document that matches the given criteria.
 *
 * @param value The criteria that the embedded document must match.
 * @return A new Criteria object that matches the given KProperty being an embedded document that matches the given criteria.
 */
infix fun KProperty<*>.elemMatch(value: Criteria) = where(this.snakeName).elemMatch(value)

/**
 * Creates a new Criteria object that matches the given field having the specified size.
 *
 * @param value The size of the field.
 * @return A new Criteria object that matches the given field having the specified size.
 */
infix fun String.size(value: Int) = where(this).size(value)

/**
 * Creates a new Criteria object that matches the given KProperty having the specified size.
 *
 * @param value The size of the KProperty.
 * @return A new Criteria object that matches the given KProperty having the specified size.
 */
infix fun KProperty<*>.size(value: Int) = where(this.snakeName).size(value)

/**
 * Creates a new Criteria object that matches the given field having the specified type.
 *
 * @param typeNumber The type of the field.
 * @return A new Criteria object that matches the given field having the specified type.
 */
infix fun String.type(typeNumber: Int) = where(this).type(typeNumber)

/**
 * Creates a new Criteria object that matches the given KProperty having the specified type.
 *
 * @param typeNumber The type of the KProperty.
 * @return A new Criteria object that matches the given KProperty having the specified type.
 */
infix fun KProperty<*>.type(typeNumber: Int) = where(this.snakeName).type(typeNumber)

/**
 * Gets a new Criteria object that matches the given field being null.
 *
 * @return A new Criteria object that matches the given field being null.
 */
val String.isNull
	get() = where(this).isNull

/**
 * Gets a new Criteria object that matches the given KProperty being null.
 *
 * @return A new Criteria object that matches the given KProperty being null.
 */
val KProperty<*>.isNull
	get() = where(this.snakeName).isNull

/**
 * Gets a new Criteria object that matches the given field being a null value.
 *
 * @return A new Criteria object that matches the given field being a null value.
 */
val String.isNullValue
	get() = where(this).isNullValue

/**
 * Gets a new Criteria object that matches the given KProperty being a null value.
 *
 * @return A new Criteria object that matches the given KProperty being a null value.
 */
val KProperty<*>.isNullValue
	get() = where(this.snakeName).isNullValue

/**
 * Returns a `Criteria` that matches documents where the field with the given name has a minimum distance of `minDistance` from the given point.
 *
 * @param minDistance The minimum distance.
 * @return A `Criteria` that matches documents where the field with the given name has a minimum distance of `minDistance` from the given point.
 */
infix fun String.minDistance(minDistance: Double) = where(this).minDistance(minDistance)

/**
 * Returns a `Criteria` that matches documents where the field with the given name has a minimum distance of `minDistance` from the given point.
 *
 * @param minDistance The minimum distance.
 * @return A `Criteria` that matches documents where the field with the given name has a minimum distance of `minDistance` from the given point.
 */
infix fun KProperty<*>.minDistance(minDistance: Double) = where(this.snakeName).minDistance(minDistance)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is greater than or equal to `maxDistance` from the given point.
 *
 * @param maxDistance The maximum distance.
 * @return A `Criteria` that matches documents where the field with the given name is greater than or equal to `maxDistance` from the given point.
 */
infix fun String.gte(maxDistance: Double) = where(this).gte(maxDistance)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is greater than or equal to `maxDistance` from the given point.
 *
 * @param maxDistance The maximum distance.
 * @return A `Criteria` that matches documents where the field with the given name is greater than or equal to `maxDistance` from the given point.
 */
infix fun KProperty<*>.gte(maxDistance: Double) = where(this.snakeName).gte(maxDistance)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is near the given point.
 *
 * @param value The point.
 * @return A `Criteria` that matches documents where the field with the given name is near the given point.
 */
infix fun String.near(value: Point) = where(this).near(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is near the given point.
 *
 * @param value The point.
 * @return A `Criteria` that matches documents where the field with the given name is near the given point.
 */
infix fun KProperty<*>.near(value: Point) = where(this.snakeName).near(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is near the given point, within a sphere of radius `radius`.
 *
 * @param value The point.
 * @return A `Criteria` that matches documents where the field with the given name is near the given point, within a sphere of radius `radius`.
 */
infix fun String.nearSphere(value: Point) = where(this).nearSphere(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is near the given point, within a sphere of radius `radius`.
 *
 * @param value The point.
 * @return A `Criteria` that matches documents where the field with the given name is near the given point, within a sphere of radius `radius`.
 */
infix fun KProperty<*>.nearSphere(value: Point) = where(this.snakeName).nearSphere(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is within the given shape.
 *
 * @param value The shape.
 * @return A `Criteria` that matches documents where the field with the given name is within the given shape.
 */
infix fun String.within(value: Shape) = where(this).within(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is within the given shape.
 *
 * @param value The shape.
 * @return A `Criteria` that matches documents where the field with the given name is within the given shape.
 */
infix fun KProperty<*>.within(value: Shape) = where(this.snakeName).within(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is within the given sphere.
 *
 * @param value The sphere.
 * @return A `Criteria` that matches documents where the field with the given name is within the given sphere.
 */
infix fun String.withinSphere(value: Circle) = where(this).withinSphere(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name is within the given sphere.
 *
 * @param value The sphere.
 * @return A `Criteria` that matches documents where the field with the given name is within the given sphere.
 */
infix fun KProperty<*>.withinSphere(value: Circle) = where(this.snakeName).withinSphere(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name exists.
 *
 * @param value Whether the field must exist or not.
 * @return A `Criteria` that matches documents where the field with the given name exists.
 */
infix fun String.exists(value: Boolean) = where(this).exists(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name exists.
 *
 * @param value Whether the field must exist or not.
 * @return A `Criteria` that matches documents where the field with the given name exists.
 */
infix fun KProperty<*>.exists(value: Boolean) = where(this.snakeName).exists(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name matches the given regular expression.
 *
 * @param value The regular expression.
 * @return A `Criteria` that matches documents where the field with the given name matches the given regular expression.
 */
infix fun String.regex(value: String) = where(this).regex(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name matches the given regular expression.
 *
 * @param value The regular expression.
 * @return A `Criteria` that matches documents where the field with the given name matches the given regular expression.
 */
infix fun KProperty<*>.regex(value: String) = where(this.snakeName).regex(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name matches the given regular expression pattern.
 *
 * @param value The regular expression pattern.
 * @return A `Criteria` that matches documents where the field with the given name matches the given regular expression pattern.
 */
infix fun String.regex(value: Pattern) = where(this).regex(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name matches the given regular expression pattern.
 *
 * @param value The regular expression pattern.
 * @return A `Criteria` that matches documents where the field with the given name matches the given regular expression pattern.
 */
infix fun KProperty<*>.regex(value: Pattern) = where(this.snakeName).regex(value)

/**
 * Returns a `Criteria` that matches documents where the field with the given name has a value that is in the given list.
 *
 * @param values The list of values.
 * @return A `Criteria` that matches documents where the field with the given name has a value that is in the given list.
 */
infix fun String.`in`(values: List<Any>?) = where(this).`in`(values)

/**
 * Returns a `Criteria` that matches documents where the field with the given name has a value that is in the given list.
 *
 * @param values The list of values.
 * @return A `Criteria` that matches documents where the field with the given name has a value that is in the given list.
 */
infix fun KProperty<*>.`in`(values: List<Any>?) = where(this.snakeName).`in`(values)

/**
 * Returns a `Criteria` that matches documents where the field with the given name does not have a value that is in the given list.
 *
 * @param values The list of values.
 * @return A `Criteria` that matches documents where the field with the given name does not have a value that is in the given list.
 */
infix fun String.nin(values: List<Any>?) = where(this).nin(values)

/**
 * Returns a `Criteria` that matches documents where the field with the given name does not have a value that is in the given list.
 *
 * @param values The list of values.
 * @return A `Criteria` that matches documents where the field with the given name does not have a value that is in the given list.
 */
infix fun KProperty<*>.nin(values: List<Any>?) = where(this.snakeName).nin(values)

/**
 * Returns a `Criteria` that matches documents where the field with the given name has all the values in the given list.
 *
 * @param values The list of values.
 * @return A `Criteria` that matches documents where the field with the given name has all the values in the given list.
 */
infix fun String.all(values: List<Any>?) = where(this).all(values)

/**
 * Returns a `Criteria` that matches documents where the field with the given name has all the values in the given list.
 *
 * @param values The list of values.
 * @return A `Criteria` that matches documents where the field with the given name has all the values in the given list.
 */
infix fun KProperty<*>.all(values: List<Any>?) = where(this.snakeName).all(values)