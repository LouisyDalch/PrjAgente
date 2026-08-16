public class PromptInadequadoException extends Exception {
    private String palavraProibidaDetectada;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public PromptInadequadoException(String prompt, String mensagem){
        super(mensagem);
        prompt = prompt.toLowerCase();
        if(prompt.contains("hackear")){
            this.palavraProibidaDetectada = "hackear";
        }else if(prompt.contains("roubar")){
            this.palavraProibidaDetectada = "roubar";
        }
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getPalavraProibidaDetectada(){ 
        return palavraProibidaDetectada;
    }
}