package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;

public interface CreateUserReportUsecase {
    void execute(String name, String userId, UserReportDetail detail);
}
