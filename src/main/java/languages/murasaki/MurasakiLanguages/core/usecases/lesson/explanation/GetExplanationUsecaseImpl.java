package languages.murasaki.MurasakiLanguages.core.usecases.lesson.explanation;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Explanation;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.ExplanationGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetExplanationUsecaseImpl implements GetExplanationByIdUsecase{

    private final ExplanationGateway explanationGateway;

    public GetExplanationUsecaseImpl(ExplanationGateway explanationGateway) {
        this.explanationGateway = explanationGateway;
    }

    @Override
    public Explanation execute(String id) {
        return explanationGateway.getExplanationById(id);
    }
}
