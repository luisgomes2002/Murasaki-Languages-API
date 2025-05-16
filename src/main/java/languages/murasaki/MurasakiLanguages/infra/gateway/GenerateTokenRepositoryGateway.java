package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.gateway.GenerateTokenGateway;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class GenerateTokenRepositoryGateway implements GenerateTokenGateway {

    private final StringRedisTemplate redisTemplate;

    public GenerateTokenRepositoryGateway(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String generateAndStoreToken(String userId) {
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token, userId, 20, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public String getUserIdByToken(String token) {
        return redisTemplate.opsForValue().get(token);
    }

    @Override
    public void deleteToken(String token) {
        redisTemplate.delete(token);
    }
}
