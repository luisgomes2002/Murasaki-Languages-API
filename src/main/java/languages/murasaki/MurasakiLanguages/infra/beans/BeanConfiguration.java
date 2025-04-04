package languages.murasaki.MurasakiLanguages.infra.beans;

import languages.murasaki.MurasakiLanguages.core.gateway.*;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.CreateBacklogUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.GetAllBacklogUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.backlog.GetAllBacklogUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.lesson.lesson.*;
import languages.murasaki.MurasakiLanguages.core.usecases.plans.*;
import languages.murasaki.MurasakiLanguages.core.usecases.report.*;
import languages.murasaki.MurasakiLanguages.core.usecases.lessoncollection.*;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecaseImpl;
import languages.murasaki.MurasakiLanguages.core.usecases.user.*;
import languages.murasaki.MurasakiLanguages.core.usecases.user.DeleteUserUsecase;
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

    @Bean
    public GetUserByIdUsecase getUserByIdUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetUserByIdUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean
    public DeleteUserUsecase deleteUserUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteUserUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean
    public UpdateUserPasswordUsecase updateUserPasswordUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateUserPasswordUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean UpdateUserTypeUsecase updateUserTypeUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateUserTypeUsecaseImpl(userGateway, authenticatedUsecase);
    }

    @Bean UpdateUserEnableUsecase updateUserEnableUsecase(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateUserEnableUsecaseImpl(userGateway, authenticatedUsecase);
    }

    // Lesson
    @Bean
    public CreateLessonUsecase createLessonUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllLessonUsecase getAllLessonUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public GetLessonByIdUsecase getLessonByIdUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetLessonByIdUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public DeleteLessonUsecase deleteLessonUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeleteLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    @Bean
    public PublishLessonUsecase publishLessoneUsecase(LessonGateway lessonGateway, AuthenticatedUsecase authenticatedUsecase){
        return new PublishLessonUsecaseImpl(lessonGateway, authenticatedUsecase);
    }

    // Report
    @Bean
    public CreateReportUsecase createReportUsecase(ReportGateway reportGateway){
        return new CreateReportUsecaseImpl(reportGateway);
    }

    @Bean
    public GetAllReportsUsecase getAllReportsUsecase(ReportGateway reportGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllReportsUsecaseImpl(reportGateway, authenticatedUsecase);
    }

    @Bean
    public UpdateReportStatusUsecase updateReportStatusUsecase(ReportGateway reportGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdateReportStatusUsecaseImpl(reportGateway, authenticatedUsecase);
    }

    // Security
    @Bean
    public AuthenticatedUsecase authenticatedUsecase(SecurityGateway securityGateway){
        return new AuthenticatedUsecaseImpl(securityGateway);
    }

    // LessonCollection
    @Bean
    public CreateLessonCollectionUsecase createLessonCollectionUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreateLessonCollectionUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllCollectionsUsecase getAllCollectionsUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllCollectionsUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public GetLessonCollectionByIdUsecase getLessonCollectionByIdUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetLessonCollectionByIdUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }

    @Bean
    public PublishLessonInCollectionUsecase publishLessonInCollectionUsecase(LessonCollectionGateway lessonCollectionGateway, AuthenticatedUsecase authenticatedUsecase){
        return new PublishLessonInCollectionUsecaseImpl(lessonCollectionGateway, authenticatedUsecase);
    }

    // Backlog
    @Bean
    public CreateBacklogUsecase createBacklogUsecase(BacklogGateway backlogGateway){
        return new CreateBacklogUsecaseImpl(backlogGateway);
    }

    @Bean
    public GetAllBacklogUsecase getAllBacklogUsecase(BacklogGateway backlogGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllBacklogUsecaseImpl(backlogGateway, authenticatedUsecase);
    }

    // Plans
    @Bean
    public CreatePlanUsecase createPlanUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new CreatePlanUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public DeletePlanUsecase deletePlanUsecase (PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new DeletePlanUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public GetAllPlansUsecase getAllPlansUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetAllPlansUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public GetPlanByIdUsecase getPlanByIdUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new GetPlanByIdUsecaseImpl(plansGateway, authenticatedUsecase);
    }

    @Bean
    public UpdatePlanUsecase updatePlanUsecase(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase){
        return new UpdatePlanUsecaseImpl(plansGateway, authenticatedUsecase);
    }
}