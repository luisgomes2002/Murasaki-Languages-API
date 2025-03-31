package languages.murasaki.MurasakiLanguages.core.usecases.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;

public class CreateReportUsecaseImpl implements CreateReportUsecase {

    private final ReportGateway reportGateway;

    public CreateReportUsecaseImpl(ReportGateway reportGateway) {
        this.reportGateway = reportGateway;
    }

    @Override
    public Report execute(Report report) {
        return reportGateway.createReport(report);
    }
}
