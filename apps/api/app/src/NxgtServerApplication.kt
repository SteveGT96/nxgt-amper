package auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["shared", "auth"])
class NxgtServerApplication

fun main(args: Array<String>) {
	runApplication<NxgtServerApplication>(*args)
}
