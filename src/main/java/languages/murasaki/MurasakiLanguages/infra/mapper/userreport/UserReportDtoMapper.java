package languages.murasaki.MurasakiLanguages.infra.mapper.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.infra.dtos.userreport.UserReportDto;
import org.springframework.stereotype.Component;

@Component
public class UserReportDtoMapper {

    public UserReportDto toDto(UserReport userReport){
        return new UserReportDto(
          userReport.id(),
          userReport.userId(),
          userReport.name(),
          userReport.updatedAt(),
          userReport.reports()
        );
    }

    public UserReport toDomain(UserReportDto userReportDto){
        return new UserReport(
            userReportDto.id(),
            userReportDto.userId(),
            userReportDto.name(),
            userReportDto.updatedAt(),
            userReportDto.reports()
        );
    }
}
