package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.report.ReportEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.report.ReportEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.report.ReportRepository;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll().stream().map(reportEntityMapper::toDomain).toList();
    }

    @Override
    public void updateReportStatus(String id, boolean finished) {
        Optional<ReportEntity> entity = reportRepository.findById(id);

        if(entity.isPresent()){
            ReportEntity updatedReport = entity.get();

            updatedReport.setFinished(finished);

            reportRepository.save(updatedReport);
        }
    }
}
