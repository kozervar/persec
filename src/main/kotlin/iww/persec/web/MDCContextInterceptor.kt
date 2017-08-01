package iww.persec.web

import iww.persec.security.JdbcUserDetails
import mu.KLogging
import org.slf4j.MDC
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class MDCContextInterceptor : HandlerInterceptor {

    companion object: KLogging()

    val MDC_USERNAME = "MDC_USERNAME"
    val MDC_IP = "MDC_IP"

    @PostConstruct
    fun postConstruct(){
        logger.info { "\n\nPOST CONSTRUCT\n\n" }
    }

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        MDC.put(MDC_USERNAME, username)
        MDC.put(MDC_IP, getIP(request!!))

        if (handler is HandlerMethod) {
            val method = handler as HandlerMethod?
            logger.debug("> {} ",
                    method!!.method
                            .name)
        }
        return true
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest?,
                            response: HttpServletResponse?,
                            handler: Any?,
                            modelAndView: ModelAndView?) {

    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest?,
                                 response: HttpServletResponse?,
                                 handler: Any?,
                                 ex: Exception?) {
        if (handler is HandlerMethod) {
            val method = handler as HandlerMethod?
            logger.debug("< {}",
                    method!!.method
                            .name)
        }
        MDC.remove(MDC_IP)
        MDC.remove(MDC_USERNAME)
    }

    val username: String
        get() {
            val authentication = SecurityContextHolder.getContext()
                    .authentication

            if (authentication == null || !authentication.isAuthenticated) {
                return ""
            }
            val principal = authentication.principal
            if (principal is JdbcUserDetails) {
                val user: JdbcUserDetails = principal
                return user.username
            }
            return ""
        }


    private fun getIP(request: HttpServletRequest): String {
        val xForwarderAddress = request.getHeader("X-FORWARDED-FOR")
        if (xForwarderAddress != null && !xForwarderAddress.isEmpty()) {
            return xForwarderAddress
        }
        return request.remoteAddr
    }
}