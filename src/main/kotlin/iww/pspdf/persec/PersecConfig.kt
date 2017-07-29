package iww.pspdf.persec

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "persec")
class PersecConfig {

    var salt:String = ""
}