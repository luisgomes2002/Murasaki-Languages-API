package languages.murasaki.MurasakiLanguages.infra.persistence.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findUserByEmail(String email);
}
