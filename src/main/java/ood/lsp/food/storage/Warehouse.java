package ood.lsp.food.storage;

import ood.lsp.food.products.Food;

import java.util.*;

public class Warehouse implements IStorage {
    private final Map<String, Set<Food>> products = new HashMap<>();

    @Override
    public Map<String, Set<Food>> get() {
        return products;
    }

    @Override
    public void add(List<Food> foodList) {
        System.out.printf("Food was added to %s\n", this.getClass());
        for (Food food : foodList) {
            products.computeIfAbsent(food.getCategory(), value -> new HashSet<>()).add(food);
        }
    }
}
