package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.userreport.UserReport;
import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.userreport.UserReportEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.userreport.UserReportRepository;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Optional;

@Configuration
public class UserReportRepositoryGateway implements UserReportGateway {

    private final UserReportRepository userReportRepository;

    public UserReportRepositoryGateway(UserReportRepository userReportRepository) {
        this.userReportRepository = userReportRepository;
    }

    @Override
    public void createUserReport(String name, String userId, String text) {
        Optional<UserReportEntity> existReport = userReportRepository.findUserReportByName(name);

        if(existReport.isPresent()){
            UserReportEntity newReport = existReport.get();

            newReport.getReports().add(text);
            newReport.setUpdatedAt(LocalDateTime.now());

            userReportRepository.save(newReport);
        }else{
            UserReportEntity entity = new UserReportEntity();

            entity.setUserId(userId);
            entity.setName(name);
            entity.getReports().add(text);
            entity.setUpdatedAt(LocalDateTime.now());

            userReportRepository.save(entity);
        }
    }
}
