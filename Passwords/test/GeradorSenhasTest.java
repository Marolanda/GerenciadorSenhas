
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeradorSenhasTest {

    @Test
    public void testGerarSenhaTamanho() {
        String senha = GeradorSenhas.gerarSenha(12);
        assertEquals(12, senha.length(), "A senha deve ter 12 caracteres");
    }

    @Test
    public void testGerarSenhaNaoNula() {
        String senha = GeradorSenhas.gerarSenha(8);
        assertNotNull(senha, "A senha não deve ser nula");
    }
}