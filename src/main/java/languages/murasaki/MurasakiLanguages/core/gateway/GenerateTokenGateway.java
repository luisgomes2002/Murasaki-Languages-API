package languages.murasaki.MurasakiLanguages.core.gateway;

public interface GenerateTokenGateway {

    String generateAndStoreToken(String userId);
    String getUserIdByToken(String token);

    void deleteToken(String token);
}
