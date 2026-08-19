public class AgenteImagem extends AgenteIA {
    public AgenteImagem(String nome,String status){
        super(nome,status);
    }
    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
        if(prompt == null){
            System.out.println("Prompt nulo detectado!");
            return;
        }
        prompt = prompt.toLowerCase();
        if (prompt.contains("roubar") || prompt.contains("hackear")||prompt.contains("biométrico")) {
            throw new PromptInadequadoException(prompt,
                    "O prompt inserido é classificado como inadequado pela presença de palavras de sentido inapropriado.");
        }else{
            System.err.println("Agente de Imagem " + Nome + " gerando resposta para: " + input);
        }
    }
}
