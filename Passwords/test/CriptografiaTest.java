import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.crypto.SecretKey;

public class CriptografiaTest {

    @Test
    public void testCriptografarNaoNulo() throws Exception {
        SecretKey chave = Criptografia.gerarChave();
        String texto = "senha123";
        String criptografado = Criptografia.criptografar(texto, chave);
        assertNotNull(criptografado);
    }
}
