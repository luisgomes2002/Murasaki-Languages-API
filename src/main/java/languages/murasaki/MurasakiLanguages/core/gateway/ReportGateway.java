package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;

import java.util.List;

public interface ReportGateway{

    Report createReport(Report report);
    List<Report> getAllReports(int page, int size);

    void updateReportStatus(String id, boolean finished);
}
