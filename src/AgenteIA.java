public abstract class AgenteIA {
    protected String nome;
    protected String status;

    public Protect(String nm,String stt){
        this.nome = nm;
        this.status = stt;
    }
    public void processarPrompt(String prompt) throws FalhaProcessamentoAgenteException {
        if (prompt == null || prompt.isEmpty()) {
            throw new FalhaProcessamentoAgenteException("O prompt não pode estar vazio.");
        }
        if (prompt.length() > 100) {
            throw new FalhaProcessamentoAgenteException("Prompt muito longo para o modelo atual.");
        }
        System.out.println("Agente processando: " + prompt);
    }

    public void validarPrompt(String prompt) throws PromptInadequadoException {
        if(prompt == null){
            System.out.println("Prompt nulo detectado!");
            return;
        }
        prompt = prompt.toLowerCase();
        if (prompt.contains("roubar") || prompt.contains("hackear")) {
            throw new PromptInadequadoException(prompt,
                    "O prompt inserido é classificado como inadequado pela presença de palavras de sentido inapropriado.");
        }
    }

    public void chamarModeloExterno() throws ErroComunicacaoIAException {
        double conexao = Math.random();
        if (conexao > 0.7) {
            throw new ErroComunicacaoIAException(conexao, "A conexão é muito fraca para comunicação.");
        }
    }
}