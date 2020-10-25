package basic.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): PasswordEncoder = NoOpPasswordEncoder.getInstance()

    @Bean
    fun userManager() : UserDetailsManager{
        val users = InMemoryUserDetailsManager()

        val user = User.withUsername("user").password("password").authorities("USER").build()
        val admin = User.withUsername("admin").password("password").authorities("ADMIN").build()

        users.createUser(user)
        users.createUser(admin)

        return users
    }

    override fun configure(http: HttpSecurity) {
        http.formLogin().defaultSuccessUrl("/public")
            .and()
            .authorizeRequests().mvcMatchers("/public").permitAll()
                .mvcMatchers("/user").authenticated()
                .mvcMatchers("/admin").hasAnyAuthority("ADMIN")
    }
}
