package custom.security.domain.validator

import custom.security.domain.UserCreateForm
import custom.security.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class UserCreateFormValidator (val userService: UserService) : Validator {

    val LOGGER = LoggerFactory.getLogger(UserCreateFormValidator::class.java)

    override fun supports(clazz: Class<*>): Boolean {
        return clazz == UserCreateForm::class.java
    }

    override fun validate(target: Any, errors: Errors) {
        LOGGER.debug("Validating {}", target)
        val form: UserCreateForm = target as UserCreateForm
        validatePasswords(errors, form)
        validateEmail(errors, form)
    }

    private fun validatePasswords(errors: Errors, form: UserCreateForm) {
        if (form.password != form.passwordRepeated) {
            errors.reject("password.no_match", "Passwords do not match")
        }
    }

    private fun validateEmail(errors: Errors, form: UserCreateForm) {
        if (userService.getUserByEmail(form.email).isPresent) {
            errors.reject("email.exists", "User with this email already exists")
        }
    }
}
