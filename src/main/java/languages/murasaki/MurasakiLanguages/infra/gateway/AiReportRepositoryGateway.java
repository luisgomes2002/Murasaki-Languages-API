package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.gateway.AiReportGateway;
import languages.murasaki.MurasakiLanguages.infra.persistence.aireport.AiReportRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Component;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AiReportRepositoryGateway implements AiReportGateway {

    private final AiReportRepository aiReportRepository;
    private final ChatClient chatClient;

    public AiReportRepositoryGateway(AiReportRepository aiReportRepository, ChatClient chatClient) {
        this.aiReportRepository = aiReportRepository;
        this.chatClient = chatClient;
    }

    @Override
    public List<AiReport> getAllAiReport(String userId) {
        return aiReportRepository.findAiReportByUserId(userId);
    }

    @Override
    public void createAiReport(String userId, UserReport userReport) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDate = userReport.updatedAt().format(formatter);

        String prompt = String.format(
                "Você é um assistente educacional. Analise os pontos de melhoria do usuário %s com base nas respostas abaixo e gere um relatório com sugestões específicas para evolução. Última atividade: %s.\n\n",
                userReport.name(), formattedDate
        );

        String pontosDeMelhoria = userReport.reports().stream()
                .map(report -> String.format("Ponto de melhoria %s: %s", report.questionId(), report.response()))
                .collect(Collectors.joining("\n"));

        String mensagemFinal = prompt + "\n\n" + pontosDeMelhoria;

        UserMessage userMessage = new UserMessage(mensagemFinal);
        Prompt chatPrompt = new Prompt(List.of(userMessage));

        String relatorioCompleto = chatClient.prompt(chatPrompt).call().content();

        System.out.println(relatorioCompleto);
    }
}
