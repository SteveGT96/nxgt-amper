package shared.types

enum class EventType {
	CREATE, UPDATE, DELETE
}

data class Event<T>(val data: T, val type: EventType = EventType.CREATE)
