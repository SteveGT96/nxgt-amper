package helpers

/**
 * Patches this set by adding the specified values and removing any values that are present in the specified iterable.
 *
 * @param values The values to add to the set.
 * @return A new set that contains the patched data.
 */
fun Set<String>.patch(values: Iterable<String>): Set<String> {
	val collection = toMutableSet() // Create a mutable copy of the set to avoid modifying the original set.

	// Filter the values to include only those that are not already in the set.
	val items = values.filter { !collection.contains(it) }

	// Remove any values from the original set that are present in the values to add.
	collection.removeIf { values.contains(it) }

	// Combine the original set (excluding the removed values) and the filtered values, and then remove any duplicates.
	return collection.plus(items).distinct().toSet()
}

/**
 * Patches this list by adding the specified values and removing any values that are present in the specified iterable.
 *
 * @param values The values to add to the list.
 * @return A new set that contains the patched data.
 */
fun List<String>.patch(values: Iterable<String>): Set<String> {
	val collection = toMutableSet() // Create a mutable copy of the list to avoid modifying the original list.

	// Filter the values to include only those that are not already in the list.
	val items = values.filter { !collection.contains(it) }

	// Remove any values from the original list that are present in the values to add.
	collection.removeIf { values.contains(it) }

	// Combine the original list (excluding the removed values) and the filtered values, and then remove any duplicates.
	return collection.plus(items).distinct().toSet()
}