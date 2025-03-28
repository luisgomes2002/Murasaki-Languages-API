package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;

public interface ReportGateway{

    Report createReport(Report report, String objectId);
}
