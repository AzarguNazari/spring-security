package custom.security.domain

import javax.persistence.*

@Entity
@Table(name = "user")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long = 0,

    @Column(name = "email", nullable = false, unique = true)
    var email: String? = null,

    @Column(name = "password_hash", nullable = false)
    var passwordHash: String? = null,

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    var role: Role? = null
)
