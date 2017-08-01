package iww.persec

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties
class PersecApplication

fun main(args: Array<String>) {
    SpringApplication.run(PersecApplication::class.java, *args)
}
