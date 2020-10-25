package custom.security.service.user

import custom.security.domain.User
import custom.security.domain.UserCreateForm
import custom.security.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun getUserById(id: Long): Optional<User> {
        LOGGER.debug("Getting user={}", id)
        return Optional.ofNullable(userRepository.findById(id).get())
    }

    override fun getUserByEmail(email: String): Optional<User> {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*".toRegex(), "@***"))
        return userRepository.findOneByEmail(email)
    }

    override fun allUsers(): Collection<Any>{
        LOGGER.debug("Getting all users")
        return userRepository.findAll(Sort.by("email"))
    }

    override fun create(form: UserCreateForm) = User(0, form.email, form.password, form.role)

}
