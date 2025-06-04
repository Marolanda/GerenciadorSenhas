import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutenticacaoTest {

    @Test
    public void testCodigo2FATamanho() {
        String codigo = Autenticacao.gerarCodigo2FA();
        assertEquals(6, codigo.length());
    }

    @Test
    public void testValidarCodigo2FA() {
        String codigo = "123456";
        assertTrue(Autenticacao.validarCodigo2FA("123456", codigo));
        assertFalse(Autenticacao.validarCodigo2FA("654321", codigo));
    }
}
