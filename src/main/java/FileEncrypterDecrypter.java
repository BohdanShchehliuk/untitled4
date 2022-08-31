import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

//public class FileEncrypterDecrypter {
//    SecretKey secretKey;
//    String transformation;
//    FileEncrypterDecrypter(SecretKey secretKey, String transformation) throws NoSuchPaddingException, NoSuchAlgorithmException {
//       this.secretKey = secretKey;
//
//        this.cipher = Cipher.getInstance(transformation);
//    }
//    void encrypt(String content, String fileName) {
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        byte[] iv = cipher.getIV();
//
//        try (FileOutputStream fileOut = new FileOutputStream(fileName);
//             CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher)) {
//            fileOut.write(iv);
//            cipherOut.write(content.getBytes());
//        }
//    }
//}
