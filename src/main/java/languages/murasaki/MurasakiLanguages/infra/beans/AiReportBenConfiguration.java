package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.AiReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.aireport.CreateAiReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.aireport.CreateAiReportUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.aireport.GetAllAiReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.aireport.GetAllAiReportUsecaseImpl;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiReportBenConfiguration {

    @Bean
    public CreateAiReportUsecase createAiReportUsecase(AiReportGateway aiReportGateway){
        return new CreateAiReportUsecaseImpl(aiReportGateway);
    }

    @Bean
    public GetAllAiReportUsecase getAllAiReportUsecase(AiReportGateway aiReportGateway){
        return new GetAllAiReportUsecaseImpl(aiReportGateway);
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
