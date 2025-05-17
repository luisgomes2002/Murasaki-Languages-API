package languages.murasaki.MurasakiLanguages.core.usecases.aireport;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.gateway.AiReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class CreateAiReportUsecaseImpl implements CreateAiReportUsecase {

    private final AiReportGateway aiReportGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public CreateAiReportUsecaseImpl(AiReportGateway aiReportGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.aiReportGateway = aiReportGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String userId, UserReport userReport) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!userInfo.subscription().equals("PREMIUM")) throw new UserDoesNotHavePermissionException("Ação bloqueada");
        
        aiReportGateway.createAiReport(userId, userReport);
    }
}
