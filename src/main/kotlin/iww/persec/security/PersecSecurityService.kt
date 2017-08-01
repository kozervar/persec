package iww.persec.security

import iww.persec.PersecConfig
import mu.KLogging
import org.abstractj.kalium.NaCl
import org.abstractj.kalium.crypto.Aead
import org.abstractj.kalium.crypto.Hash
import org.abstractj.kalium.crypto.Password
import org.abstractj.kalium.encoders.Encoder
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
class PersecSecurityService(val config: PersecConfig) {

    companion object : KLogging()

    private var encoderSodium = Encoder.HEX
    private val hashSodium = Hash()
    private val passwordSodium = Password()
    private var aead: Aead? = null

    @PostConstruct
    fun init() {
        NaCl.init()
        aead = Aead(config.security.priv, encoderSodium)
        logger.info { "Security service initialized" }
    }

    fun getEncryptedPassword(password: String): String {

        val sha512 = hashSodium.sha512(password, encoderSodium)

        val opsLimit = NaCl.Sodium.CRYPTO_PWHASH_SCRYPTSALSA208SHA256_OPSLIMIT_INTERACTIVE
        val memLimit = NaCl.Sodium.CRYPTO_PWHASH_SCRYPTSALSA208SHA256_MEMLIMIT_INTERACTIVE
        val hash = passwordSodium.hash(sha512.toByteArray(), encoderSodium, opsLimit, memLimit.toLong())

        val encryptedAead = aead?.encrypt(config.security.pub.toByteArray(), hash.toByteArray(), config.security.pepper.toByteArray())

        return encoderSodium.encode(encryptedAead)
    }

    fun verifyPassword(password:String, encryptedPassword:String):Boolean {
        // var enc = getEncryptedPassword(password)
        // println("||" + enc + "||\n")
        val sha512 = hashSodium.sha512(password, encoderSodium)
        val decryptedPasswordHash = getDecryptedPasswordHash(encryptedPassword)
        val verify = passwordSodium.verify(encoderSodium.decode(decryptedPasswordHash), sha512.toByteArray())
        return verify
    }

    private fun getDecryptedPasswordHash(password: String): String {
        val decrypted = aead?.decrypt(config.security.pub.toByteArray(), encoderSodium.decode(password), config.security.pepper.toByteArray())
        if (decrypted != null) {
            return String(decrypted)
        }
        throw IllegalStateException("Could not decrypt password")
    }
}