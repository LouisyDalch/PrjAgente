public class ErroComunicacaoException extends Exception{
    private double conexao;

    public double getConexao() {
        return conexao;
    }

    public ErroComunicacaoException(double conexao, String mensagem) {
        super(mensagem);
        this.conexao = conexao;
    }
    
}