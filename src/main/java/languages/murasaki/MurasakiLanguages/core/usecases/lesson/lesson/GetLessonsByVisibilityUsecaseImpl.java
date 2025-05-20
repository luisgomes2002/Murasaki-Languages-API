package languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Lesson;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.enums.SubscriptionType;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetLessonsByVisibilityUsecaseImpl implements GetLessonsByVisibilityUsecase{

    private final LessonGateway lessonGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetLessonsByVisibilityUsecaseImpl(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonGateway = lessonGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<Lesson> execute(Visibility visibility, int page, int size) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        SubscriptionType userSubscription = SubscriptionType.valueOf(userInfo.subscription());

        if (visibility.equals(Visibility.PRIVATE)
                && userSubscription != SubscriptionType.BASIC
                && userSubscription != SubscriptionType.PRO
                && userSubscription != SubscriptionType.PREMIUM) {
            throw new UserDoesNotHavePermissionException("Ação bloqueada");
        }

        return lessonGateway.getLessonsByVisibility(visibility, page, size);
    }
}
