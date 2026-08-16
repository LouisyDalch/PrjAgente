public class ErroComunicacaoIAException extends Exception{
    private double conexao;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public double getConexao() {
        return conexao;
    }

    public ErroComunicacaoIAException(double conexao, String mensagem) {
        super(mensagem);
        this.conexao = conexao;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }
    
}