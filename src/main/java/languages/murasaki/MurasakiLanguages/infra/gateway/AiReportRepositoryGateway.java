package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.gateway.AiReportGateway;
import languages.murasaki.MurasakiLanguages.infra.persistence.aireport.AiReportEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.aireport.AiReportRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        String formattedDate = userReport.updatedAt().format(formatter);

        String prompt = String.format(
                "Você é um assistente educacional que conversa diretamente com o aluno, de forma amigável, clara e motivadora. " +
                        "Abaixo estão explicações de erros cometidos pelo usuário %s em questões de múltipla escolha. " +
                        "Com base nessas informações, escreva um relatório diretamente para o aluno, analisando de forma integrada as principais dificuldades observadas, " +
                        "identificando padrões e sugerindo caminhos objetivos para a evolução. " +
                        "Não repita os erros individualmente, mas use-os como base para uma análise geral. " +
                        "Não use sugestões condicionais como 'se quiser'. " +
                        "Comece com uma saudação pelo nome do aluno e inclua a seguinte linha no relatório:\n\n" +
                        "Data da última atividade: %s\n\n" +
                        "Explicações dos erros cometidos:\n",
                userReport.name(), formattedDate
        );

        String explicacoesDeErro = userReport.reports().stream()
                .map(report -> "- " + report.response())
                .collect(Collectors.joining("\n"));

        String mensagemFinal = prompt + explicacoesDeErro;

        UserMessage userMessage = new UserMessage(mensagemFinal);
        Prompt chatPrompt = new Prompt(List.of(userMessage));

        String relatorioCompleto = chatClient.prompt(chatPrompt).call().content();

        AiReportEntity entity = new AiReportEntity(userId, relatorioCompleto);

        aiReportRepository.save(entity);
    }
}
