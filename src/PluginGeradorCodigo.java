public class PluginGeradorCodigo implements IAcaoAgente{
    public void processarRequisicao(String prompt) throws Exception{
        if (prompt.length()>50) {
            throw new FalhaProcessamentoAgenteException("Prompt excedeu o tamanho máximo");
        }else{
            conectarServidor();
            System.out.println("Executando prompt: "+prompt);
        }

    }
}

