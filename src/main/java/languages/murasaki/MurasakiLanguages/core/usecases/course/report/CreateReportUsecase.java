package languages.murasaki.MurasakiLanguages.core.usecases.course.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;

public interface CreateReportUsecase {

    Report execute(Report report, String objectId);
}
