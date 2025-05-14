package languages.murasaki.MurasakiLanguages.infra.mapper.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.aireport.AiReport;
import languages.murasaki.MurasakiLanguages.infra.persistence.aireport.AiReportEntity;
import org.springframework.stereotype.Component;

@Component
public class AiReportEntityMapper {

    public AiReportEntity toEntity(AiReport aiReport){
        return new AiReportEntity(
                aiReport.userId(),
                aiReport.report()
        );
    }

    public AiReport toDomain(AiReportEntity aiReport){
        return new AiReport(
          aiReport.getUserId(),
          aiReport.getReport()
        );
    }
}
