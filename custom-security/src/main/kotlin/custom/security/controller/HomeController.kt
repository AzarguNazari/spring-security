package custom.security.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    val LOGGER = LoggerFactory.getLogger(HomeController::class.java)

    @GetMapping("/")
    fun homePage() = "home"
}
