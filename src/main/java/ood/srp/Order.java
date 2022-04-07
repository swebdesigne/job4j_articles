package ood.srp;

import java.util.List;

public class Order {
    private int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void orderInfo() {
        getOrderFromDb()
                .stream().forEach(System.out::println);
    }

    private void initDb() {
        System.out.println("Connect to db ...");
    }

    private List<Order> getOrderFromDb() {
        System.out.println("Extract data of the product by id " + orderId + "from db");
        System.out.println("Collect to list and return ...");
        return null;
    }
}
