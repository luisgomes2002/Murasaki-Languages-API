package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.UserEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.User.UserEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.User.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        UserEntity newUSer = userRepository.save(entity);
        return userEntityMapper.toDomain(newUSer);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(userEntityMapper::toDomain).toList();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).map(userEntityMapper::toDomain).orElse(null);
    }

    @Override
    public boolean userAlreadyCreated(String email) {
        return userRepository.findAll().stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    @Override
    public User updateUser(String id, User user) {
        Optional<UserEntity> entity = userRepository.findById(id);

        if(entity.isPresent()){
            UserEntity updatedUser = entity.get();
            updatedUser.setName(user.name());
            updatedUser.setEmail(user.email());
            updatedUser.setPassword(user.password());
            updatedUser.setCreatedAt(entity.get().getCreatedAt());
            updatedUser.setUpdatedAt(LocalDateTime.now());
            updatedUser.setUserType(user.userType());

            userRepository.save(updatedUser);

            return userEntityMapper.toDomain(updatedUser);
        }

        return null;
    }

    @Override
    public boolean userIdExists(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
