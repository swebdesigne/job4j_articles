package ood.lsp.food.products;

import java.time.LocalDate;

public class Ananas extends Food {
    public Ananas(String name, double price, int discount, String category, LocalDate createDate, LocalDate expireDate) {
        super(name, price, discount, category, createDate, expireDate);
    }
}
