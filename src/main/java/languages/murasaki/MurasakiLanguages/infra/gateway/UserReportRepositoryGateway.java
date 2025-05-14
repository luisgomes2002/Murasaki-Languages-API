package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReportDetail;
import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportRepository;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Configuration
public class UserReportRepositoryGateway implements UserReportGateway {

    private final UserReportRepository userReportRepository;

    public UserReportRepositoryGateway(UserReportRepository userReportRepository) {
        this.userReportRepository = userReportRepository;
    }

    @Override
    public void createUserReport(String name, String userId, UserReportDetail detail) {
        Optional<UserReportEntity> existReport = userReportRepository.findUserReportByName(name);

        if(existReport.isPresent()){
            UserReportEntity newReport = existReport.get();

            boolean alreadyExists = newReport.getReports().stream()
                    .anyMatch(r -> r.questionId().equals(detail.questionId()));

            if (!alreadyExists) {
                newReport.getReports().add(detail);
                newReport.setUpdatedAt(LocalDateTime.now());

                userReportRepository.save(newReport);
            }
        }else{
            UserReportEntity entity = new UserReportEntity();

            entity.setUserId(userId);
            entity.setName(name);
            entity.setReports(new ArrayList<>());
            entity.getReports().add(detail);
            entity.setUpdatedAt(LocalDateTime.now());

            userReportRepository.save(entity);
        }
    }

    @Override
    public void removeUserReport(String name, String questionId) {
        Optional<UserReportEntity> existReport = userReportRepository.findUserReportByName(name);

        if (existReport.isPresent()) {
            UserReportEntity report = existReport.get();

            boolean removed = report.getReports().removeIf(r -> r.questionId().equals(questionId));

            if (removed) {
                report.setUpdatedAt(LocalDateTime.now());
                userReportRepository.save(report);
            }
        }
    }
}
