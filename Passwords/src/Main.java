import java.util.Scanner;
import javax.crypto.SecretKey;

/**
 * Classe principal do Gerenciador de Senhas.
 * Exibe o menu e executa as funcionalidades principais.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Garante que a tabela existe antes de qualquer operação
            BancoDados.criarTabela();

            // Gere a chave AES uma vez e use sempre a mesma durante a execução
            SecretKey chaveAES = Criptografia.gerarChaveAES();

            System.out.println("== GERENCIADOR DE SENHAS ==");
            System.out.println("1 - Gerar Senha Segura");
            System.out.println("2 - Autenticar com 2FA");
            System.out.println("3 - Cadastrar Credencial");

            int opcao = input.nextInt();
            input.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    // Gera e exibe uma senha segura
                    System.out.println("Senha sugerida: " + GeradorSenhas.gerarSenha(12));
                    break;
                case 2:
                    // Autenticação 2FA e verificação de vazamento
                    System.out.print("Digite sua senha: ");
                    String senha = input.nextLine();

                    if (VerificadorVazamento.senhaVazada(senha)) {
                        System.out.println("⚠️  Esta senha já foi vazada! Por favor, use outra senha.");
                        break;
                    }

                    String codigo = Autenticacao.gerarCodigo2FA(); // Gera e mostra o código
                    System.out.print("Digite o código recebido: ");
                    String codigoInserido = input.nextLine();

                    if (Autenticacao.validarCodigo2FA(codigoInserido, codigo)) {
                        System.out.println("✅ Autenticado com sucesso!");
                    } else {
                        System.out.println("❌ Código incorreto.");
                    }
                    break;
                case 3:
                    // Cadastro de nova credencial
                    System.out.print("Serviço: ");
                    String servico = input.nextLine();
                    System.out.print("Usuário: ");
                    String usuario = input.nextLine();
                    System.out.print("Senha: ");
                    String senhaCadastro = input.nextLine();

                    // Criptografa a senha antes de armazenar
                    String senhaCriptografada = Criptografia.criptografar(senhaCadastro, chaveAES);

                    // Salva no banco de dados
                    BancoDados.salvarCredencial(servico, usuario, senhaCriptografada);

                    System.out.println("Credencial cadastrada com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
