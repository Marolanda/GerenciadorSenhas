import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class BancoDadosTest {

    @BeforeEach
    public void limparTabela() throws Exception {
        // Limpa a tabela antes de cada teste
        BancoDados.criarTabela();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:credenciais.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM credenciais");
        }
    }

    @Test
    public void testSalvarEListarCredencial() throws Exception {
        // Salva uma credencial
        BancoDados.salvarCredencial("testeServico", "testeUsuario", "senhaCriptografada");

        // Verifica se a credencial foi salva
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:credenciais.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM credenciais WHERE servico='testeServico'")) {

            assertTrue(rs.next(), "A credencial deve estar presente no banco");
            assertEquals("testeServico", rs.getString("servico"));
            assertEquals("testeUsuario", rs.getString("usuario"));
            assertEquals("senhaCriptografada", rs.getString("senha"));
        }
    }
}