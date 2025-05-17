package languages.murasaki.MurasakiLanguages.core.usecases.payment;

public interface PaymentHandleEventUsecase {

    void handleEvent(String payload, String sigHeader);
}
