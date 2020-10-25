package custom.security.service.currentuser

import custom.security.domain.CurrentUser
import custom.security.domain.User
import custom.security.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CurrentUserDetailsService(val userService: UserService) : UserDetailsService {

    val LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService::class.java)

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): CurrentUser {
        LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*".toRegex(), "@***"))
        val user: User? = userService.getUserByEmail(email)
                .orElseThrow { UsernameNotFoundException("User with email=$email was not found") }
        return CurrentUser(user)
    }
}
