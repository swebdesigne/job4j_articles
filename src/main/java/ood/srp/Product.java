package ood.srp;

public class Product {
    private double price;

    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        try {
            this.price = price;
        } catch (Exception e) {
            writeToLog(e);
        }
    }

    private void writeToLog(Exception e) {
        System.out.println("Write to log");
    }
}
