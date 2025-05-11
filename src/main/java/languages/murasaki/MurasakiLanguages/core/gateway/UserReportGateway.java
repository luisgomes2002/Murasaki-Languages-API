package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;

public interface UserReportGateway {

    void createUserReport(String name, String userId, String text);
}
