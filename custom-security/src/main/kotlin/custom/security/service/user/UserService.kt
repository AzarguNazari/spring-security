package custom.security.service.user

import custom.security.domain.User
import custom.security.domain.UserCreateForm
import java.util.*

interface UserService {
    fun getUserById(id: Long): Optional<User>
    fun getUserByEmail(email: String): Optional<User>
    fun allUsers(): Collection<Any>
    fun create(form: UserCreateForm): User?
}