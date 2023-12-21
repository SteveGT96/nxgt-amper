package auth.entities

import java.time.Clock
import java.time.Instant

data class Token(
	var issuedAt: Instant = Instant.now(Clock.systemUTC()),
	var expiration: Instant = Instant.now(Clock.systemUTC()),
	val access: String,
	val refresh: String,
	val username: String,
)