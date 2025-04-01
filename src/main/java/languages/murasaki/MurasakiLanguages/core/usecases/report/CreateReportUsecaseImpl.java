package languages.murasaki.MurasakiLanguages.core.usecases.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;

public class CreateReportUsecaseImpl implements CreateReportUsecase {

    private final ReportGateway reportGateway;

    public CreateReportUsecaseImpl(ReportGateway reportGateway) {
        this.reportGateway = reportGateway;
    }

    @Override
    public Report execute(Report report) {
        
        if(report.text() == null) throw new MissingArgumentsException("Campos faltando");

        return reportGateway.createReport(report);
    }
}
