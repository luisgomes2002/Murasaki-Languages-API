package languages.murasaki.MurasakiLanguages.infra.mapper.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.infra.dtos.course.ReportDto;
import org.springframework.stereotype.Component;

@Component
public class ReportDtoMapper {

    public ReportDto toDto(Report report){
        return new ReportDto(
            report.id(),
            report.userId(),
            report.objectId(),
            report.reportType(),
            report.user(),
            report.text(),
            report.finished()
        );
    }

    public Report toDomain(ReportDto reportDto){
        return new Report(
            reportDto.id(),
            reportDto.userId(),
            reportDto.objectId(),
            reportDto.reportType(),
            reportDto.user(),
            reportDto.text(),
            reportDto.finished()
        );
    }
}
