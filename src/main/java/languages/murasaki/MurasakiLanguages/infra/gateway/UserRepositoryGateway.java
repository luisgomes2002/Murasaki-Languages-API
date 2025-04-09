package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.infra.config.TokenConfiguration;
import languages.murasaki.MurasakiLanguages.infra.exceptions.EmailOrPasswordIncorrectException;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.UserEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserEntity;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfiguration tokenConfiguration;


    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenConfiguration tokenConfiguration) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfiguration = tokenConfiguration;
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);

        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setIcon("");
        entity.setBackground("");
        entity.setUserType(UserType.valueOf("COMMUM"));
        entity.setAbout("Ainda não criou uma descrição");
        entity.setEnabled(true);

        String password = entity.getPassword();
        entity.setPassword(passwordEncoder.encode(password));

        UserEntity newUser = userRepository.save(entity);
        return userEntityMapper.toDomain(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().map(userEntityMapper::toDomain).toList();
    }

    @Override
    @Cacheable(value = "user", key = "#id")
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
            updatedUser.setUsername(user.username());
            updatedUser.setEmail(user.email());
            updatedUser.setIcon(user.icon());
            updatedUser.setBackground(user.background());
            updatedUser.setAbout(user.about());
            updatedUser.setGender(user.gender());
            updatedUser.setBirth(user.birth());
            updatedUser.setUpdatedAt(LocalDateTime.now());

            updatedUser.setCreatedAt(entity.get().getCreatedAt());

            userRepository.save(updatedUser);

            return userEntityMapper.toDomain(updatedUser);
        }

        return null;
    }

    @Override
    public User updateUserPassword(String id, String newPassword) {
        Optional<UserEntity> entity = userRepository.findById(id);

        if(entity.isPresent()){
            UserEntity updatedUser = entity.get();

            updatedUser.setPassword(passwordEncoder.encode(newPassword));
            updatedUser.setUpdatedAt(LocalDateTime.now());

            UserEntity newUser = userRepository.save(updatedUser);

            return userEntityMapper.toDomain(newUser);
        }

        return null;
    }

    @Override
    public void updateUserType(String id, UserType type) {
        Optional<UserEntity> entity = userRepository.findById(id);

        if(entity.isPresent()){
            UserEntity updatedUser = entity.get();

            updatedUser.setUserType(type);
            updatedUser.setUpdatedAt(LocalDateTime.now());

            userRepository.save(updatedUser);
        }
    }

    @Override
    public boolean userIdExists(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public void isEnable(String id, boolean isEnable) {
        Optional<UserEntity> entity = userRepository.findById(id);

        if(entity.isPresent()){
            UserEntity updatedUser = entity.get();

            updatedUser.setEnabled(isEnable);
            updatedUser.setUpdatedAt(LocalDateTime.now());

            userRepository.save(updatedUser);
        }
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public String login(Login login) {
        Optional<UserEntity> entity = userRepository.findUserByEmail(login.email());

        if (!passwordEncoder.matches(login.password(), entity.get().getPassword())) {
            throw new EmailOrPasswordIncorrectException("Email ou senha incorretos");
        }

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(login.email(), login.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        UserEntity user = (UserEntity) authentication.getPrincipal();

        return tokenConfiguration.generateToken(user);
    }
}
