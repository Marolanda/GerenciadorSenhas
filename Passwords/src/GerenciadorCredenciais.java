import java.util.ArrayList;
import java.util.List;

/**
 * Classe para gerenciar uma lista de credenciais em memória.
 */
public class GerenciadorCredenciais {
    private List<Credencial> credenciais = new ArrayList<>();

    /**
     * Adiciona uma credencial à lista.
     * @param credencial Credencial a ser adicionada.
     */
    public void adicionarCredencial(Credencial credencial) {
        credenciais.add(credencial);
    }

    /**
     * Retorna a lista de credenciais.
     * @return Lista de credenciais.
     */
    public List<Credencial> listarCredenciais() {
        return credenciais;
    }
}