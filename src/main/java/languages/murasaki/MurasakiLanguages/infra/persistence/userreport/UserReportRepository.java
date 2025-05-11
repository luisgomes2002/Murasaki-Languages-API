package languages.murasaki.MurasakiLanguages.infra.persistence.userreport;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserReportRepository extends MongoRepository<UserReportEntity, String> {

    Optional<UserReportEntity> findUserReportByName(String name);
}
