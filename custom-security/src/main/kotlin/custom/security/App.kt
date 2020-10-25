package custom.security

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomSecurity

fun main(args: Array<String>) {
	runApplication<CustomSecurity>(*args)
}
