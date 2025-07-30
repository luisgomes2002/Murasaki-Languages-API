package languages.murasaki.MurasakiLanguages.core.usecases.email;

public interface RenewedSubscriptionUsecase {

    void execute(String email, String payment, String userName, String productName);
}
