import java.security.SecureRandom;

/**
 * Classe responsável por gerar senhas seguras aleatórias.
 */
public class GeradorSenhas {
    // Conjunto de caracteres permitidos na senha
    private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";

    /**
     * Gera uma senha aleatória com o tamanho especificado.
     * @param tamanho O tamanho desejado para a senha.
     * @return Uma senha forte composta pelos caracteres definidos.
     */
    public static String gerarSenha(int tamanho) {
        SecureRandom random = new SecureRandom(); // Gerador de números aleatórios seguro
        StringBuilder senha = new StringBuilder();

        // Adiciona caracteres aleatórios até atingir o tamanho desejado
        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString(); // Retorna a senha gerada
    }

    /**
     * Método principal para testar a geração de senha.
     * Gera e imprime uma senha forte de 12 caracteres.
     */
    public static void main(String[] args) {
        System.out.println("Senha forte: " + gerarSenha(12));
    }
}
