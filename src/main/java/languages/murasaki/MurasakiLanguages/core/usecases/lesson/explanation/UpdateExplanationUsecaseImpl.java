package languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.ExplanationGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateExplanationUsecaseImpl implements UpdateExplanationUsecase{

    private final ExplanationGateway explanationGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateExplanationUsecaseImpl(ExplanationGateway explanationGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.explanationGateway = explanationGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Explanation execute(String id, Explanation explanation) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(explanation.phrase().isEmpty() || explanation.translation().isEmpty() || explanation.explanation().isEmpty()) throw new MissingArgumentsException("Peencha todos os campos");

        return explanationGateway.updateExplanation(id, explanation);
    }
}
