package ood.lsp.food.products;

import java.time.LocalDate;
import java.util.Objects;

public class Food {
    private String name;
    private double price;
    private int discount;
    private String category;


    private LocalDate createDate;
    private LocalDate expireDate;

    public Food(String name, double price, int discount, String category, LocalDate createDate, LocalDate expireDate) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.createDate = createDate;
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && discount == food.discount
                && Objects.equals(name, food.name)
                && Objects.equals(category, food.category)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expireDate, food.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discount, category, createDate, expireDate);
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name
                + ", price=" + price
                + ", discount=" + discount
                + ", category='" + category
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + '}';
    }
}
