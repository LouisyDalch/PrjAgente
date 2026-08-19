public class AgenteTexto extends AgenteIA {
    
    public AgenteTexto(String nome,String status){
        super(nome,status);
    }

    @Override @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
            if (input.length()>500) {
                throw new FalhaProcessamentoAgenteException("Prompt excedeu o tamanho máximo");
            }else{
                conectarServidor();
                System.err.println("Agente de Texto " + Nome + " gerando resposta para: " + input);
            }
            
    }

}
