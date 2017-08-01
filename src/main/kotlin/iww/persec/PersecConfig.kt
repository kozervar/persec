package iww.persec

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "persec")
class PersecConfig {

    var security: Security = Security()

    class Security {

        var pepper = ""

        var pub = ""

        var priv = ""
    }
}