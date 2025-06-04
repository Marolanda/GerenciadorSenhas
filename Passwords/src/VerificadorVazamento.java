import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

/**
 * Classe responsável por verificar se uma senha já foi exposta em vazamentos,
 * utilizando a API "Have I Been Pwned".
 */
public class VerificadorVazamento {

    /**
     * Verifica se a senha foi vazada consultando a API.
     * @param senha Senha a ser verificada.
     * @return true se a senha foi vazada, false caso contrário.
     */
    public static boolean senhaVazada(String senha) {
        try {
            String sha1 = gerarSHA1(senha);
            String prefixo = sha1.substring(0, 5);
            String sufixo = sha1.substring(5).toUpperCase();

            java.net.URI uri = new java.net.URI("https", "api.pwnedpasswords.com", "/range/" + prefixo, null);
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.startsWith(sufixo)) {
                    return true; // Senha foi vazada!
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Senha não foi encontrada
    }

    /**
     * Gera o hash SHA-1 da senha.
     * @param senha Senha em texto puro.
     * @return Hash SHA-1 em hexadecimal.
     */
    private static String gerarSHA1(String senha) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] bytes = md.digest(senha.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().toUpperCase();
    }
}
