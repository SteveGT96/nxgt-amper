package models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Clock
import java.time.Instant

data class Token(
	var issuedAt: Instant = Instant.now(Clock.systemUTC()),
	var expiration: Instant = Instant.now(Clock.systemUTC()),
	val access: String,
	val refresh: String,
	val username: String,
)