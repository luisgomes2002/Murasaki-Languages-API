package languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.ExplanationGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class DeleteExplanationUsecaseImpl implements DeleteExplanationUsecase{

    private final ExplanationGateway explanationGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public DeleteExplanationUsecaseImpl(ExplanationGateway explanationGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.explanationGateway = explanationGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        explanationGateway.deleteExplanation(id);
    }
}
