package languages.murasaki.MurasakiLanguages.core.usecases.generatetoken;

import languages.murasaki.MurasakiLanguages.core.gateway.GenerateTokenGateway;

public class GetUserIdByTokenUsecaseImpl implements  GetUserIdByTokenUsecase{

    private final GenerateTokenGateway gateway;

    public GetUserIdByTokenUsecaseImpl(GenerateTokenGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String execute(String token) {
        return gateway.getUserIdByToken(token);
    }
}
