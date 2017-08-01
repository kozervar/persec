package iww.persec.security

import org.springframework.security.crypto.password.PasswordEncoder


class PersecPasswordEncoder(val persecSecurityService: PersecSecurityService) : PasswordEncoder {
    override fun encode(rawPassword: CharSequence?): String {
        return persecSecurityService.getEncryptedPassword(rawPassword.toString())
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
        return persecSecurityService.verifyPassword(rawPassword.toString(), encodedPassword!!)
    }

}