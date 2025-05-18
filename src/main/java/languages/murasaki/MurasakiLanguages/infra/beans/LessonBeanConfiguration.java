package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.LessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LessonBeanConfiguration {

    @Bean
    public CreateLessonUsecase createLessonUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllLessonUsecase getAllLessonUsecase(LessonGateway lessonGateway){
        return new GetAllLessonUsecaseImpl(lessonGateway);
    }

    @Bean
    public GetLessonByIdUsecase getLessonByIdUsecase(LessonGateway lessonGateway){
        return new GetLessonByIdUsecaseImpl(lessonGateway);
    }

    @Bean
    public GetLessonsByPublishedTrueUsecase getLessonsByPublishedTrueUsecase(LessonGateway lessonGateway) {
        return new GetLessonsByPublishedTrueUsecaseImpl(lessonGateway);
    }

    @Bean
    public GetLessonsByPublishedOrNotUsecase getLessonsByPublishedUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase ){
        return new GetLessonsByPublishedOrNotUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public GetLessonsByVisibilityUsecase getLessonsByVisibilityUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetLessonsByVisibilityUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public GetPublicLessonsUsecase getPublicLessonsUsecase(LessonGateway lessonGateway){
        return new GetPublicLessonsUsecaseImpl(lessonGateway);
    }

    @Bean
    public DeleteLessonUsecase deleteLessonUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public PublishLessonUsecase publishLessoneUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new PublishLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public UpdateLessonUsecase updateLessonUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public AddWorksheetsUsecase addWorksheetsUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new AddWorksheetsUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public AddExplanationUsecase addExplanationUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new AddExplanationUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public RemoveWorksheetsUsecase removeWorksheetsUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new RemoveWorksheetsUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public RemoveExplanationUsecase removeExplanationUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new RemoveExplanationUsecaseImpl(lessonGateway, authenticatedUsecase);
    }
}
