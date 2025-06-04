import java.util.Random;

/**
 * Classe responsável por gerar e validar códigos de autenticação de dois fatores (2FA).
 */
public class Autenticacao {

    /**
     * Gera um código aleatório de 6 dígitos para autenticação.
     * @return Código 2FA como String.
     */
    public static String gerarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Gera número de 6 dígitos
        return String.valueOf(codigo);
    }

    /**
     * Gera e exibe um código 2FA.
     * @return Novo código 2FA.
     */
    public static String gerarCodigo2FA() {
        String codigo = gerarCodigo();
        System.out.println("Seu código 2FA é: " + codigo);
        return codigo;
    }

    /**
     * Valida se o código digitado pelo usuário corresponde ao código gerado.
     * @param codigoDigitado Código informado pelo usuário.
     * @param codigoGerado Código gerado pelo sistema.
     * @return true se os códigos forem iguais, false caso contrário.
     */
    public static boolean validarCodigo2FA(String codigoDigitado, String codigoGerado) {
        return codigoGerado.equals(codigoDigitado);
    }
}
