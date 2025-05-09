package languages.murasaki.MurasakiLanguages.core.usecases.order;

import languages.murasaki.MurasakiLanguages.core.entities.order.Order;
import languages.murasaki.MurasakiLanguages.core.gateway.OrderGateway;

public class CreateOrderUsecaseImpl implements CreateOrderUsecase {

    private final OrderGateway orderGateway;

    public CreateOrderUsecaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order execute(Order order) {
        return orderGateway.createOrder(order);
    }
}
