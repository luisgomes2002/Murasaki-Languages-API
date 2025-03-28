package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.*;
import languages.murasaki.MurasakiLanguages.core.usecases.course.course.*;
import languages.murasaki.MurasakiLanguages.core.usecases.course.report.CreateReportUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.course.report.CreateReportUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.coursecollection.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.user.*;
import languages.murasaki.MurasakiLanguages.infra.gateway.ReportRepositoryGateway;
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
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) { return new GetAllUsersUseCaseImpl(userGateway, authenticatedUsecase);}

    @Bean
    public LoginUsecase loginUsecase(UserGateway userGateway){
        return new LoginUsecaseImpl(userGateway);
    }

    @Bean
    public UpdateUserUsecase updateUserUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {return new UpdateUserUsecaseImpl(userGateway, authenticatedUsecase);}

    // Course
    @Bean
    public CreateCourseUsecase createCourseUsecase(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateCourseUsecaseImpl(courseGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllCoursesUsecase getAllCoursesUsecase(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllCoursesUsecaseImpl(courseGateway, authenticatedUsecase);
    }

    @Bean
    public GetCourseByIdUsecase getCourseByIdUsecase(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetCourseByIdUsecaseImpl(courseGateway, authenticatedUsecase);
    }

    @Bean
    public DeleteCourseUsecase deleteCourseUsecase(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteCourseUsecaseImpl(courseGateway, authenticatedUsecase);
    }

    @Bean
    public PublishCourseUsecase publishCourseUsecase(CourseGateway courseGateway, AuthenticatedUsecase authenticatedUsecase){
        return new PublishCourseUsecaseImpl(courseGateway, authenticatedUsecase);
    }

    // Report
    @Bean
    public CreateReportUsecase createReportUsecase(ReportGateway reportGateway){
        return new CreateReportUsecaseImpl(reportGateway);
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
    public GetCourseCollectionByIdUsecase getCourseCollectionByIdUsecase(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetCourseCollectionByIdUsecaseImpl(courseCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public PublishCourseInCollectionUsecase publishCourseInCollectionUsecase(CourseCollectionGateway courseCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new PublishCourseInCollectionUsecaseImpl(courseCollectionGateway, authenticatedUsecase);
    }


}
