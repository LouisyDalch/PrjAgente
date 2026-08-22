public class ModeloConexao {
    public static void validarLink() throws ErroComunicacaoIAException{
        double conexao = Math.random();
        if (conexao > 0.8) {
            throw new ErroComunicacaoIAException(conexao, "Link indisponível no momento");
        }else{
            System.err.println("Link validado!");
        }
    }
}
