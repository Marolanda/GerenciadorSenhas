import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe utilitária para operações no banco de dados SQLite.
 */
public class BancoDados {
    private static final String URL = "jdbc:sqlite:credenciais.db";

    /**
     * Cria a tabela de credenciais se ela não existir.
     */
    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS credenciais (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "servico TEXT," +
                     "usuario TEXT," +
                     "senha TEXT)";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Salva uma nova credencial no banco de dados.
     * @param servico Nome do serviço.
     * @param usuario Nome do usuário.
     * @param senhaCriptografada Senha já criptografada.
     */
    public static void salvarCredencial(String servico, String usuario, String senhaCriptografada) {
        String sql = "INSERT INTO credenciais(servico, usuario, senha) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, servico);
            pstmt.setString(2, usuario);
            pstmt.setString(3, senhaCriptografada);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todas as credenciais salvas no banco de dados.
     */
    public static void listarCredenciais() {
        String sql = "SELECT id, servico, usuario, senha FROM credenciais";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Serviço | Usuário | Senha Criptografada");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s%n",
                        rs.getInt("id"),
                        rs.getString("servico"),
                        rs.getString("usuario"),
                        rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}