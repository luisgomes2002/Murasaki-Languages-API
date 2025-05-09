package languages.murasaki.MurasakiLanguages.core.entities.order;

public record Order(
        String email,
        double amount,
        String paymentToken,
        String paymentMethodId,
        int installments,
        String externalReference
) { }
