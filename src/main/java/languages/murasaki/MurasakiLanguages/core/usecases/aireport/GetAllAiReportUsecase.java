package languages.murasaki.MurasakiLanguages.core.usecases.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;

import java.util.List;

public interface GetAllAiReportUsecase {

    List<AiReport> execute(String userId, int page, int size);
}
