package iww.pspdf.persec.security

import iww.pspdf.persec.PersecConfig
import mu.KLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PersecSecurityServiceTest {

    companion object : KLogging()

    @Test
    fun shouldTestFunctionality() {
        val config = PersecConfig()
        config.security.pepper = "[<~A 32-bytes pepper for aead~>]"
        config.security.pub = "PerSec77"
        config.security.priv = "1234567890123456789012345678901212345678901234567890123456789012"

        val service = PersecSecurityService(config)
        service.init()

        // when
//        val encryptedPassword = service.getEncryptedPassword("test")
//        println(encryptedPassword)
        val encryptedPassword = "b9d7e6c96d2a46e52c6097db7b885c28186cf127aed7bcad41868b96f8e726d390c3b25ea98b44fce57eed23ba9705c647d9fd9b5bf6274676d2465a6b6cf08c0536d569e4d78f8dff945333b85c1329d905c09c8fea395a5daa72e0580cc39e64c6734c8a73e530b389ddfa733d28815353661fd4637ded9823fce036426f52f42ae6e89be8de27455f5bd76a25fbdfd72a28243f79b1161692aa55dd35569624203fd9ae551f29b1766579cb3cf238d1f0576b9bde5e1b4d16dc8970757a80aa4466d3753f84c5e7913a8f351141680978f03e3fbaeb0b3ba86729"
        val verificationNotOk = service.verifyPassword("test1", encryptedPassword)
        val verificationOk = service.verifyPassword("test", encryptedPassword)

        // then
        assertThat(encryptedPassword).isNotNull().isNotBlank()
        assertThat(verificationNotOk).isFalse()
        assertThat(verificationOk).isTrue()
    }
}