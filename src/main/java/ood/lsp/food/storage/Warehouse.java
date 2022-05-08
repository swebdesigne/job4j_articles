package ood.lsp.food.storage;

import ood.lsp.food.products.Food;
import ood.lsp.food.IControlQuality;

import java.util.*;

public class Warehouse implements IControlQuality {
    private Map<String, Set<Food>> products = new HashMap<>();

    @Override
    public Map<String, Set<Food>> getProducts() {
        return products;
    }

    @Override
    public void store(List<Food> foodList) {
        System.out.printf("Food was added to %s\n", this.getClass());
        for (Food food : foodList) {
            products.computeIfAbsent(food.getCategory(), value -> new HashSet<>()).add(food);
        }
    }
}
