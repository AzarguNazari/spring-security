package basicAuthentication

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @GetMapping("/public")
    fun publicView() : String{
        return "public.html";
    }

    @GetMapping("/user-view")
    fun userView() : String{
        return "user.html";
    }

    @GetMapping("/admin-view")
    fun adminView() : String{
        return "admin.html";
    }




}