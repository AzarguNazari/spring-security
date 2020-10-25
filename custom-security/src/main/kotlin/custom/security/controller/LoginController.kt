package custom.security.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.util.*

@Controller
class LoginController {

    val LOGGER = LoggerFactory.getLogger(LoginController::class.java)

    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    fun getLoginPage(@RequestParam error: Optional<String>): ModelAndView {
        LOGGER.debug("Getting login page, error={}", error)
        return ModelAndView("login", "error", error)
    }
}
