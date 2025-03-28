package languages.murasaki.MurasakiLanguages.infra.mapper.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.infra.persistence.report.ReportEntity;
import org.springframework.stereotype.Component;

@Component
public class ReportEntityMapper {

    public ReportEntity toEntity(Report report){
        return new ReportEntity(
            report.id(),
            report.userId(),
            report.objectId(),
            report.reportType(),
            report.user(),
            report.text(),
            report.finished()
        );
    }

    public Report toDomain(ReportEntity reportEntity){
        return new Report(
            reportEntity.getId(),
            reportEntity.getUserId(),
            reportEntity.getObjectId(),
            reportEntity.getReportType(),
            reportEntity.getUser(),
            reportEntity.getText(),
            reportEntity.isFinished()
        );
    }
}
