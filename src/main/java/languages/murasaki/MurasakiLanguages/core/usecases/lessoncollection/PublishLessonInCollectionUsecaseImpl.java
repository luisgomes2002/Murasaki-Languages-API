package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class PublishLessonInCollectionUsecaseImpl implements PublishLessonInCollectionUsecase {

    public final LessonCollectionGateway lessonCollectionGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public PublishLessonInCollectionUsecaseImpl(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.lessonCollectionGateway = lessonCollectionGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public String execute(String collectionId, String lessoneId, boolean status) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"BOSS".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(collectionId == null || lessoneId == null){
            throw new MissingArgumentsException("Campo faltando");
        }

       return lessonCollectionGateway.publishLessonInCollection(collectionId, lessoneId, status);
    }
}
