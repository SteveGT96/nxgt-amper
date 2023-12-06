package auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories(basePackages = ["auth", "shared"])
@SpringBootApplication(scanBasePackages = ["shared", "auth"])
class NxgtServerApplication

fun main(args: Array<String>) {
	runApplication<NxgtServerApplication>(*args)
}
