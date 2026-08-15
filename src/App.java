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
            double conexao = Math.random();
            int index = random.nextInt(prompts.length);
            String prompt = prompts[index];
            System.out.println(i);
            System.out.println(prompt);
            try {
                agente.validarPrompt(prompt);
                agente.processarPrompt(prompt);
                agente.verificarConexao(conexao);

            } catch (FalhaProcessamentoAgenteException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Timestamp do erro: " + e.getTimestamp());
            } catch (PromptInadequadoException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Palavra proibida detectada: " + e.getPalavraProibidaDetectada());

            } catch (ErroComunicacaoException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Conexão detectada: " + e.getConexao());
            }
        }

    }
}
