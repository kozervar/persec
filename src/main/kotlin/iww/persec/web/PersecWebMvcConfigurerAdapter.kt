package iww.persec.web

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class PersecWebMvcConfigurerAdapter(val mdcContextInterceptor: MDCContextInterceptor) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(mdcContextInterceptor)
    }
}