package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;

public class CreateUserReportUsecaseImpl implements CreateUserReportUsecase{

    private final UserReportGateway userReportGateway;

    public CreateUserReportUsecaseImpl(UserReportGateway userReportGateway) {
        this.userReportGateway = userReportGateway;
    }

    @Override
    public void execute(String name, String userId, UserReportDetail detail) {
        userReportGateway.createUserReport(name, userId, detail);
    }
}
