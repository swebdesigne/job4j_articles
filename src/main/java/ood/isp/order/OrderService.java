package ood.isp.order;

public interface OrderService {
    Order createOrder();
    Order getOrder(int orderId);
    Order submitOrder(int orderId);
    Order processOrder(int orderId);
}
