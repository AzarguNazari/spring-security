package custom.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
internal class SecurityConfig(val userDetailsService: UserDetailsService) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
            .antMatchers("/", "/public/**").permitAll()
            .antMatchers("/users/**").hasAuthority("ADMIN")
            .anyRequest().fullyAuthenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .usernameParameter("email")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .deleteCookies("remember-me")
            .logoutSuccessUrl("/")
            .permitAll()
            .and()
            .rememberMe()
    }

    @Throws(Exception::class)
    public override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//                .passwordEncoder(new BCryptPasswordEncoder());
    }
}