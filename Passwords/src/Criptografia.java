import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * Classe utilitária para criptografia e geração de chaves AES.
 */
public class Criptografia {

    /**
     * Gera uma chave AES de 128 bits.
     * @return Chave secreta AES.
     */
    public static SecretKey gerarChaveAES() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128 bits
        return keyGen.generateKey();
    }

    /**
     * Criptografa um texto usando uma chave AES.
     * @param texto Texto a ser criptografado.
     * @param chave Chave AES.
     * @return Texto criptografado em Base64.
     */
    public static String criptografar(String texto, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    public static void main(String[] args) throws Exception {
        SecretKey chave = gerarChaveAES();
        String senha = "minhasenha123";
        String criptografada = criptografar(senha, chave);
        System.out.println("Senha criptografada: " + criptografada);
    }
}