package custom.security.controller

import custom.security.domain.CurrentUser
import custom.security.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.util.*

@Controller
class LoginController {

    val LOGGER = LoggerFactory.getLogger(LoginController::class.java)

    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    fun getLoginPage(@RequestParam error: Optional<String>): ModelAndView {
        LOGGER.debug("Getting login page, error=$error")
        return ModelAndView("login", "error", error)
    }
}

@Controller
class MainController(val userService: UserService)  {

    @GetMapping("/")
    fun homePage() = "home"

    @GetMapping("/users")
    fun usersPage() = ModelAndView("users", "users", userService.allUsers())
}


@ControllerAdvice
class CurrentUserControllerAdvice {

    @ModelAttribute("currentUser")
    fun getCurrentUser(authentication: Authentication?) = authentication?.principal as? CurrentUser
}
