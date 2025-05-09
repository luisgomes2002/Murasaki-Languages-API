package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.order.Order;

public interface OrderGateway {

    Order createOrder(Order order);
}
