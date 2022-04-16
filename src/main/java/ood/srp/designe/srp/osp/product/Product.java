package ood.srp.designe.srp.osp.product;

public class Product {
    private Logger logger;

    public Product(Logger logger) {
        this.logger = logger;
    }

    public void setPrice(double price) {
        try {
            System.out.println("Do something");
        } catch (Exception e) {
            logger.log(e.getMessage());
        }
    }
}
