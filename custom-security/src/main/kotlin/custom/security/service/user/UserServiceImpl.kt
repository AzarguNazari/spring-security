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

    override fun getUserById(id: Long) = Optional.ofNullable(userRepository.findById(id).get())

    override fun getUserByEmail(email: String) = userRepository.findOneByEmail(email)

    override fun allUsers() = userRepository.findAll(Sort.by("email"))

    override fun create(form: UserCreateForm) = User(0, form.email, form.password, form.role)

}
