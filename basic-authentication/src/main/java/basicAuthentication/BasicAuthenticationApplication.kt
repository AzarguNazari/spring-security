package basicAuthentication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicAuthenticationApplication


fun main(args: Array<String>) {
    runApplication<BasicAuthenticationApplication>(*args)
}

