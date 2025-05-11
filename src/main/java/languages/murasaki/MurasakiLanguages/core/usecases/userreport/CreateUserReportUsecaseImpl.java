package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;

public class CreateUserReportUsecaseImpl implements CreateUserReportUsecase{

    private final UserReportGateway userReportGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public CreateUserReportUsecaseImpl(UserReportGateway userReportGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userReportGateway = userReportGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String name, String userId, String text) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

//        if(userInfo.subscription() != SubscriptionType.PREMIUM)

        userReportGateway.createUserReport(name, userId, text);
    }
}
