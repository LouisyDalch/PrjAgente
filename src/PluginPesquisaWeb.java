public class PluginPesquisaWeb implements IAcaoAgente {
    @Override
    public void processarRequisicao(String prompt) throws Exception{
        if(prompt.toLowerCase().contains("hacker")||
        prompt.toLowerCase().contains("roubar")){
            throw new PromptInadequadoException(prompt,"prompt inadequado, verifique e tente novamente ");

        }
        System.out.println("Executando prompt: "+prompt);
    }
}
