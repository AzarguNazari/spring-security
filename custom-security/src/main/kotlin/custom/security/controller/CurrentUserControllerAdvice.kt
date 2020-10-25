package custom.security.controller

import custom.security.domain.CurrentUser
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class CurrentUserControllerAdvice {
    @ModelAttribute("currentUser")
    fun getCurrentUser(authentication: Authentication?): CurrentUser? {
        return if (authentication == null) null else authentication.principal as CurrentUser
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice::class.java)
    }
}