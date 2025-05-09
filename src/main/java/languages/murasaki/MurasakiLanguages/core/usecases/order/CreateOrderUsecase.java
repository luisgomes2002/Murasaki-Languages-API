package languages.murasaki.MurasakiLanguages.core.usecases.order;

import languages.murasaki.MurasakiLanguages.core.entities.order.Order;

public interface CreateOrderUsecase {

    Order execute(Order order);
}
