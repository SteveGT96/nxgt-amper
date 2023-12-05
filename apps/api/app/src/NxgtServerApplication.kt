package com.strange

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NxgtServerApplication

fun main(args: Array<String>) {
	runApplication<NxgtServerApplication>(*args)
}
