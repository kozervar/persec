package iww.pspdf.persec.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
class PersecWebSecurityConfigurerAdapter(val userDetailsService: JdbcUserDetailsService, val persecSecurityService: PersecSecurityService) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        val passwordEncoder = PersecPasswordEncoder(persecSecurityService)
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(passwordEncoder)
    }

    override fun configure(http: HttpSecurity?) {
        http
                ?.authorizeRequests()
                ?.anyRequest()?.authenticated()
                ?.and()
                ?.exceptionHandling()
                ?.and()
                ?.httpBasic()
    }
}