package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.report.ReportEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.report.ReportEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.report.ReportRepository;
import org.springframework.stereotype.Component;

@Component
public class ReportRepositoryGateway implements ReportGateway {

    private final ReportRepository reportRepository;
    private final ReportEntityMapper reportEntityMapper;

    public ReportRepositoryGateway(ReportRepository reportRepository, ReportEntityMapper reportEntityMapper) {
        this.reportRepository = reportRepository;
        this.reportEntityMapper = reportEntityMapper;
    }

    @Override
    public Report createReport(Report report) {
        ReportEntity entity = reportEntityMapper.toEntity(report);

        reportRepository.save(entity);

        return reportEntityMapper.toDomain(entity);
    }
}
