package custom.security.controller

import custom.security.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class UsersController(val userService: UserService)  {

    val LOGGER = LoggerFactory.getLogger(UsersController::class.java)

    @GetMapping("/users")
    fun usersPage(): ModelAndView {
        LOGGER.debug("Getting users page")
        return ModelAndView("users", "users", userService.allUsers())
    }
}