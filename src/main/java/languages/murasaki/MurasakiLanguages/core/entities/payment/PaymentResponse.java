package languages.murasaki.MurasakiLanguages.core.entities.payment;

import languages.murasaki.MurasakiLanguages.core.enums.PaymentType;

public record PaymentResponse(String email, String productName, String userName, PaymentType paymentType) {
}
