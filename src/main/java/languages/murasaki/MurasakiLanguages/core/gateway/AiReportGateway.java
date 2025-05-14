package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;

import java.util.List;

public interface AiReportGateway {

    List<AiReport> getAllAiReport(String userId);

    void createAiReport(String userId, UserReport userReport);
}
