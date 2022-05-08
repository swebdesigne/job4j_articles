package ood.lsp.food.products;

import java.time.LocalDate;

public class Banana extends Food {
    public Banana(String name, double price, int discount, String category, LocalDate createDate, LocalDate expireDate) {
        super(name, price, discount, category, createDate, expireDate);
    }
}
