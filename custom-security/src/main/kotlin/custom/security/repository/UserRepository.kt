package custom.security.repository

import custom.security.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    fun findOneByEmail(email: String): Optional<User>
}
