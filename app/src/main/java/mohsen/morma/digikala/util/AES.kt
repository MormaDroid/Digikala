package mohsen.morma.digikala.util

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object AES {
    fun encryptAES(value: String, key: String, iv: String): String {

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec : SecretKey = SecretKeySpec(key.toByteArray(),"AES")
        val ivSpec = IvParameterSpec(iv.toByteArray())
        cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec)
        val encrypt = cipher.doFinal(value.toByteArray())

        return Base64.encodeToString(encrypt,Base64.DEFAULT)

    }

    fun decryptAES(value: String, key: String, iv: String): String {

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec : SecretKey = SecretKeySpec(key.toByteArray(),"AES")
        val ivSpec = IvParameterSpec(iv.toByteArray())
        cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec)
        val decode = Base64.decode(value,Base64.DEFAULT)
        val decrypt = cipher.doFinal(decode)
        return String(decrypt)

    }
}