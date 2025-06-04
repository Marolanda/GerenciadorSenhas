/**
 * Classe que representa uma credencial de acesso a um serviço.
 */
public class Credencial {
    private String servico;
    private String usuario;
    private String senhaCriptografada;

    /**
     * Construtor da credencial.
     * @param servico Nome do serviço.
     * @param usuario Nome do usuário.
     * @param senhaCriptografada Senha criptografada.
     */
    public Credencial(String servico, String usuario, String senhaCriptografada) {
        this.servico = servico;
        this.usuario = usuario;
        this.senhaCriptografada = senhaCriptografada;
    }

    public String getServico() { return servico; }
    public String getUsuario() { return usuario; }
    public String getSenhaCriptografada() { return senhaCriptografada; }
}