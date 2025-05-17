package languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection;

import languages.murasaki.MurasakiLanguages.core.entities.lessoncollection.lessonCollection;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllCollectionsUsecaseImpl implements GetAllCollectionsUsecase{

    private final LessonCollectionGateway lessonCollectionGateway;

    public GetAllCollectionsUsecaseImpl(LessonCollectionGateway lessonCollectionGateway) {
        this.lessonCollectionGateway = lessonCollectionGateway;
    }

    @Override
    public List<lessonCollection> execute() {

        return lessonCollectionGateway.getAllCollections();
    }
}
