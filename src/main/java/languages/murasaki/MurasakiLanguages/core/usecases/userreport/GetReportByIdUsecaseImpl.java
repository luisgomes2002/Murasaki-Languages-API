package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;

public class GetReportByIdUsecaseImpl implements GetReportByIdUsecase{

    private final UserReportGateway userReportGateway;

    public GetReportByIdUsecaseImpl(UserReportGateway userReportGateway) {
        this.userReportGateway = userReportGateway;
    }

    @Override
    public UserReport execute(String userReportId) {
        return userReportGateway.getReportById(userReportId);
    }
}
