package languages.murasaki.MurasakiLanguages.core.usecases.generatetoken;

import languages.murasaki.MurasakiLanguages.core.gateway.GenerateTokenGateway;

public class GenerateAndStoreTokenUsecaseImpl implements GenerateAndStoreTokenUsecase {

    private final GenerateTokenGateway gateway;

    public GenerateAndStoreTokenUsecaseImpl(GenerateTokenGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String execute(String userId) {
        return gateway.generateAndStoreToken(userId);
    }
}
