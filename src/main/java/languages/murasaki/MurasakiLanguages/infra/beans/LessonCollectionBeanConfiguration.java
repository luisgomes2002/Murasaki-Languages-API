package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.LessonCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LessonCollectionBeanConfiguration {

    @Bean
    public CreateLessonCollectionUsecase createLessonCollectionUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateLessonCollectionUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllCollectionsUsecase getAllCollectionsUsecase(LessonCollectionGateway lessonCollectionGateway){
        return new GetAllCollectionsUsecaseImpl(lessonCollectionGateway);
    }

    @Bean
    public GetLessonCollectionByIdUsecase getLessonCollectionByIdUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetLessonCollectionByIdUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public UpdateLessonCollectionUsecase updateLessonCollectionUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateLessonCollectionUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }
}
