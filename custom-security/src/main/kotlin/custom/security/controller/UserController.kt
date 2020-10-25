package custom.security.controller


import custom.security.domain.UserCreateForm
import custom.security.domain.validator.UserCreateFormValidator
import custom.security.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.validation.Valid

@Controller
@RequestMapping("user")
class UserController (val userService: UserService, val userCreateFormValidator: UserCreateFormValidator) {

    val LOGGER = LoggerFactory.getLogger(UserController::class.java)

    @InitBinder("form")
    fun initBinder(binder: WebDataBinder) {
        binder.addValidators(userCreateFormValidator)
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @GetMapping("/{id}")
    fun getUserPage(@PathVariable id: Long): ModelAndView {
        LOGGER.debug("Getting user page for user={}", id)
        return ModelAndView("user", "user", userService.getUserById(id)
                .orElseThrow { NoSuchElementException("User=$id not found") })
    }

    @GetMapping(value = ["/create"])
    @PreAuthorize("hasAuthority('ADMIN')")
    fun userCreatePage(): ModelAndView{
            LOGGER.debug("Getting user create form")
            return ModelAndView("user_create", "form", UserCreateForm())
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = ["/create"])
    fun handleUserCreateForm(@Valid @ModelAttribute("form") form: UserCreateForm, bindingResult: BindingResult): String {

        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult)
        if (bindingResult.hasErrors()) {
            // failed validation
            return "user_create"
        }
        try {
            userService.create(form)
        } catch (e: DataIntegrityViolationException) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e)
            bindingResult.reject("email.exists", "Email already exists")
            return "user_create"
        }
        // ok, redirect
        return "redirect:/users"
    }

}