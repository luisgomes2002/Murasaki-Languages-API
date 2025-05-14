package languages.murasaki.MurasakiLanguages.core.usecases.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;

public interface CreateAiReportUsecase {

    void execute(String userId, UserReport userReport);
}
