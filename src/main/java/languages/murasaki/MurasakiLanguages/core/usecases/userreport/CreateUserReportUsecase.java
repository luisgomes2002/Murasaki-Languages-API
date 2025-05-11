package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;

public interface CreateUserReportUsecase {
    void execute(String name, String userId, String text);
}
