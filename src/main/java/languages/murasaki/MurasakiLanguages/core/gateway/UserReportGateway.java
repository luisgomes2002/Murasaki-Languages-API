package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;

import java.util.Optional;

public interface UserReportGateway {

    UserReport getReportById(String reportId);

    void createUserReport(String name, String userId, UserReportDetail detail);
    void removeUserReport(String name, String userId, String questionId);
}
