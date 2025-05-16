package languages.murasaki.MurasakiLanguages.core.usecases.generatetoken;

import languages.murasaki.MurasakiLanguages.core.gateway.GenerateTokenGateway;

public class DeleteTokenUsecaseImpl implements DeleteTokenUsecase{

    private final GenerateTokenGateway gateway;

    public DeleteTokenUsecaseImpl(GenerateTokenGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(String token) {
        gateway.deleteToken(token);
    }
}
