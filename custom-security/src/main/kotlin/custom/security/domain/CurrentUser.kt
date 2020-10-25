package custom.security.domain

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User as SecurityUser

data class CurrentUser(val user: User?) : SecurityUser(user?.email, user?.passwordHash, AuthorityUtils.createAuthorityList(user?.role.toString())) {
    val id: Long? = user?.id
    val role: Role? = user?.role
}