package languages.murasaki.MurasakiLanguages.core.usecases.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import languages.murasaki.MurasakiLanguages.core.gateway.AiReportGateway;

import java.util.List;

public class GetAllAiReportUsecaseImpl implements GetAllAiReportUsecase{

    private final AiReportGateway aiReportGateway;

    public GetAllAiReportUsecaseImpl(AiReportGateway aiReportGateway) {
        this.aiReportGateway = aiReportGateway;
    }

    @Override
    public List<AiReport> execute(String userId) {
        return aiReportGateway.getAllAiReport(userId);
    }
}
