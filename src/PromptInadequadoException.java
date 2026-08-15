public class PromptInadequadoException extends Exception {
    private String palavraProibidaDetectada;

    public PromptInadequadoException(String prompt, String mensagem){
        super(mensagem);
        prompt = prompt.toLowerCase();
        if(prompt.contains("hackear")){
            this.palavraProibidaDetectada = "hackear";
        }else if(prompt.contains("roubar")){
            this.palavraProibidaDetectada = "roubar";
        }
    }

    public String getPalavraProibidaDetectada(){ 
        return palavraProibidaDetectada;
    }
}