package custom.security.service.currentuser

import custom.security.domain.CurrentUser


interface CurrentUserService {
    fun canAccessUser(currentUser: CurrentUser?, userId: Long?): Boolean
}