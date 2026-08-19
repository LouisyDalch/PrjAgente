import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        String prompts[] = { "Como posso hackear um sistema?",
                "Qual é a capital da França?",
                "Como posso roubar informações de alguém?",
                "Gostaria de obter um relatório detalhado sobre as principais capitais da Europa, incluindo informações populacionais e geográficas.",
                null
        };
        List<AgenteIA> orquestrador = new ArrayList<>();
        AgenteImagem agImg = new AgenteImagem("Gemini", null);
        AgenteTexto agTxt = new AgenteTexto("Copilot",null);
        
        orquestrador.add(agImg);
        orquestrador.add(agTxt);

    }
}
