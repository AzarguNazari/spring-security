package custom.security.service.currentuser

import custom.security.domain.CurrentUser
import custom.security.domain.Role
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CurrentUserServiceImpl : CurrentUserService {

    val LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService::class.java)

    override fun canAccessUser(currentUser: CurrentUser, userId: Long): Boolean {
        LOGGER.debug("Checking if user=$currentUser has access to user=$userId")
        return (currentUser?.role === Role.ADMIN || currentUser?.id == userId)
    }
}
