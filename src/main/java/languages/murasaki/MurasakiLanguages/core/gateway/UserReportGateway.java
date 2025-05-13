package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;

public interface UserReportGateway {

    void createUserReport(String name, String userId, UserReportDetail detail);
    void removeUserReport(String name, String questionId);
}
