public class AgenteImagem extends AgenteIA {
    public AgenteImagem(String nome,String status){
        super(nome,status);
    }
    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException {
        if(input == null){
            System.out.println("Prompt nulo detectado!");
            return;
        }
        input = input.toLowerCase();
        if (input.contains("roubar") || input.contains("hackear")||input.contains("biométrico")) {
            throw new PromptInadequadoException(input,
                    "O prompt inserido é classificado como inadequado pela presença de palavras de sentido inapropriado.");
        }else{
            System.err.println("Agente de Imagem " + nome + " gerando resposta para: " + input);
        }
    }
}
