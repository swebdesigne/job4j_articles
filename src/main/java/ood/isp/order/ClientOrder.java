package ood.isp.order;

public class ClientOrder implements OrderService {
    @Override
    public Order createOrder() {
        return null;
    }

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public Order submitOrder(int orderId) {
        return null;
    }

    @Override
    public Order processOrder(int orderId) {
        throw new  UnsupportedOperationException("I not support this method");
    }
}
