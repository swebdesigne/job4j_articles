package ood.isp.order;

public class Order implements OrderService {
    @Override
    public Order createOrder() {
        throw new  UnsupportedOperationException("I not support this method");
    }

    @Override
    public Order getOrder(int orderId) {
        throw new  UnsupportedOperationException("I not support this method");
    }

    @Override
    public Order submitOrder(int orderId) {
        throw new  UnsupportedOperationException("I not support this method");
    }

    @Override
    public Order processOrder(int orderId) {
        return null;
    }
}
