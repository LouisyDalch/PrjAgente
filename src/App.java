import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String prompts[] = { "Como posso hackear um sistema?",
                "Qual é a capital da França?",
                "Como posso roubar informações de alguém?",
                "Gostaria de obter um relatório detalhado sobre as principais capitais da Europa, incluindo informações populacionais e geográficas.",
                null,
                "Como obter dados biométricos de alguém?"
        };
        //comentado para nova atividade
        List<AgenteIA> orquestrador = new ArrayList<>();
        //AgenteImagem agImg = new AgenteImagem("Gemini", null);
        AgenteTexto agTxt = new AgenteTexto("Copilot",null);
        //orquestrador.add(agImg);
        orquestrador.add(agTxt);
        PluginPesquisaWeb plugPesqWeb = new PluginPesquisaWeb();
        PluginGeradorCodigo plugGerCod = new PluginGeradorCodigo();

        agTxt.usarHabilidade(plugGerCod,"Como aprender java?");
        agTxt.usarHabilidade(plugPesqWeb,"Como aprender java?");
        int i = -1;
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Como posso hackear um sistema?");
        System.out.println("2 - Qual é a capital da França?");
        System.out.println("3 - Como posso roubar informações de alguém?");
        System.out.println("4 - Gostaria de obter um relatório detalhado sobre as principais capitais da Europa, incluindo informações populacionais e geográficas.");
        System.out.println("5 - null");
        System.out.println("6 - Como obter dados biométricos de alguém?");
        System.out.println("0 - Sair");
        i = sc.nextInt();
        if(i!=0){
            processarFila(orquestrador,prompts[i-1]);
        }
    
        sc.close();
    }

    public static void processarFila(List<AgenteIA> lista, String comando) throws FalhaProcessamentoAgenteException, PromptInadequadoException, ErroComunicacaoIAException{
        for(AgenteIA ia : lista){
            ModeloConexao.validarLink();
            ia.processarRequisicao(comando);
        }
    }
}
