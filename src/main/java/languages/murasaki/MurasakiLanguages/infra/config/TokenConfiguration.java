package languages.murasaki.MurasakiLanguages.infra.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.UserInfoDto;
import languages.murasaki.MurasakiLanguages.infra.persistence.User.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfiguration {

    @Value("${murasakilanguages.security.secret}")
    private String secret;

    public String generateToken(UserEntity userEntity){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(userEntity.getEmail())
                .withClaim("userId", userEntity.getId())
                .withClaim("username", userEntity.getUsername())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API Murasaki Languages")
                .sign(algorithm);
    }

    public Optional<UserInfoDto> verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT verify = JWT.require(algorithm).build().verify(token);

            String userId = verify.getClaim("userId").asString();
            String username = verify.getClaim("username").asString();
            String email = verify.getSubject();

            UserInfoDto userData = new UserInfoDto(userId, username, email);

            return Optional.of(userData);

        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }
}
