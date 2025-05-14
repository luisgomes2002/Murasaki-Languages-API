package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.CompletedLessonGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.completedlesson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompletedLessonBeanConfiguration {

    @Bean
    public AddLessonUsecase addLessonUsecase(CompletedLessonGateway completedLessonGateway){
        return new AddLessonUsecaseImpl(completedLessonGateway);
    }

    @Bean
    public RemoveLessonUsecase removeLessonUsecase(CompletedLessonGateway completedLessonGateway){
        return new RemoveLessonUsecaseImpl(completedLessonGateway);
    }

    @Bean
    public GetAllCompletedLessonsUsecase getAllCompletedLessonsUsecase(CompletedLessonGateway completedLessonGateway){
        return new GetAllCompletedLessonsUsecaseImpl(completedLessonGateway);
    }
}
