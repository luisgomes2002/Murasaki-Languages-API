package languages.murasaki.MurasakiLanguages.core.usecases.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;

import java.util.List;

public interface GetAllReportsUsecase {

    List<Report> execute(int page, int size);
}
