package custom.security.domain

data class UserCreateForm(
    var email: String = "",
    var password: String = "",
    var passwordRepeated: String = "",
    var role: Role = Role.USER
)
