package languages.murasaki.MurasakiLanguages.core.usecases.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.gateway.AiReportGateway;

public class CreateAiReportUsecaseImpl implements CreateAiReportUsecase {

    private final AiReportGateway aiReportGateway;

    public CreateAiReportUsecaseImpl(AiReportGateway aiReportGateway) {
        this.aiReportGateway = aiReportGateway;
    }

    @Override
    public void execute(String userId, UserReport userReport) {
        aiReportGateway.createAiReport(userId, userReport);
    }
}
