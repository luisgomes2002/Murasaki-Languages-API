package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;

public interface GetReportByIdUsecase {
   UserReport execute(String userReportId);
}
