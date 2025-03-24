package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.CourseCollectionGateway;
import languages.murasaki.MurasakiLanguages.core.gateway.CourseGateway;
import languages.murasaki.MurasakiLanguages.core.gateway.SecurityGateway;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.course.CreateCourseUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.course.CreateCourseUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.user.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // User
    @Bean
    public CreateUserUsecase createUserUseCase(UserGateway userGateway){
        return new CreateUserUsecaseImpl(userGateway);
    }

    @Bean
    public LoginUsecase loginUsecase(UserGateway userGateway){
        return new LoginUsecaseImpl(userGateway);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway) { return new GetAllUsersUseCaseImpl(userGateway);}

    // Course
    @Bean
    public CreateCourseUsecase createCourseUsecase(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateCourseUsecaseImpl(courseGateway, authenticatedUsecase);
    }

    // Security
    @Bean
    public AuthenticatedUsecase authenticatedUsecase(SecurityGateway securityGateway){
        return new AuthenticatedUsecaseImpl(securityGateway);
    }

    // CourseCollection
    @Bean
    public CreateCourseCollectionUsecase createCourseCollectionUsecase(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateCourseCollectionUsecaseImpl(courseCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllCollectionsUsecase getAllCollectionsUsecase(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllCollectionsUsecaseImpl(courseCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public GetCourseCollectionByIdUsecase getCourseCollectionByIdUsecase(CourseCollectionGateway courseCollectionGateway){
        return new GetCourseCollectionByIdUsecaseImpl(courseCollectionGateway);
    }

}
