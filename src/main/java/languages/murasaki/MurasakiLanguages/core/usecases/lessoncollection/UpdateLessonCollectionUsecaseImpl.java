package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.LessonCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateLessonCollectionUsecaseImpl implements  UpdateLessonCollectionUsecase{

  private final LessonCollectionGateway lessonCollectionGateway;
  private final AuthenticatedUsecase authenticatedUsecase;

  public UpdateLessonCollectionUsecaseImpl(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase) {
    this.lessonCollectionGateway = lessonCollectionGateway;
    this.authenticatedUsecase = authenticatedUsecase;
  }

  @Override
  public void execute(String collectionId, LessonCollection lessonCollection) {
    UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

    if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

    lessonCollectionGateway.updateCollection(collectionId, lessonCollection);
  }
}
