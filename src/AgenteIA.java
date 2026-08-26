public abstract class AgenteIA{
    protected String nome;
    protected String status;

    public AgenteIA(String nm,String stt){
        this.nome = nm;
        this.status = stt;
    }

    public String getNome(){
        return nome;
    }

    public void conectarServidor() throws ErroComunicacaoIAException {
        double conexao = Math.random();
        if (conexao > 0.7) {
            throw new ErroComunicacaoIAException(conexao, "A conexão é muito fraca para comunicação.");
        }else{
            System.err.println("Servidor conectado!");
        }
    }

    public void usarHabilidade(IAcaoAgente ferramenta, String comando){
        ferramenta.processarRequisicao(comando);
    }

    public abstract void processarRequisicao(String input) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException;

    
}