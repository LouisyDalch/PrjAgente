import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        String prompts[] = { "Como posso hackear um sistema?",
                "Qual é a capital da França?",
                "Como posso roubar informações de alguém?",
                "Gostaria de obter um relatório detalhado sobre as principais capitais da Europa, incluindo informações populacionais e geográficas."

        };
        Random random = new Random();
        AgenteIA agente = new AgenteIA();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(prompts.length);
            String prompt = prompts[index];
            System.out.println(i);
            System.out.println(prompt);
            try {
                agente.validarPrompt(prompt);
                agente.processarPrompt(prompt);
                agente.chamarModeloExterno();

            } catch (FalhaProcessamentoAgenteException e) {
                System.out.println("[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: " + e.getMessage());
            } catch (PromptInadequadoException e) {
                System.out.println("[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: " + e.getMessage() + " Palavra proibida detectada: " + e.getPalavraProibidaDetectada());
            } catch (ErroComunicacaoIAException e) {
                System.out.println("[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: " + e.getMessage());
            }
        }

    }
}
