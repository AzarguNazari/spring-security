package basic.security

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CustomController{

    @GetMapping("/public")
    fun public() = "public.html"

    @GetMapping("/user")
    fun user() = "user.html"

    @GetMapping("/admin")
    fun admin() = "admin.html"

}

