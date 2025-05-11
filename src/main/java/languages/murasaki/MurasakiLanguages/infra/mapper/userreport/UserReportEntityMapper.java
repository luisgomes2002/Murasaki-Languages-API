package languages.murasaki.MurasakiLanguages.infra.mapper.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportEntity;
import org.springframework.stereotype.Component;

@Component
public class UserReportEntityMapper {

    public UserReportEntity toEntity(UserReport userReport){
        return new UserReportEntity(
          userReport.id(),
          userReport.userId(),
          userReport.name(),
          userReport.updatedAt(),
          userReport.reports()
        );
    }

    public UserReport toDomain(UserReportEntity userReport){
        return new UserReport(
          userReport.getId(),
          userReport.getUserId(),
          userReport.getName(),
          userReport.getUpdatedAt(),
          userReport.getReports()
        );
    }
}
