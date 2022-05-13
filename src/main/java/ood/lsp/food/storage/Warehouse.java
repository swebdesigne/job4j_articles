package ood.lsp.food.storage;

import ood.lsp.food.manage.date.ProductControlDate;
import ood.lsp.food.products.Food;

import java.util.*;

public class Warehouse implements IStorage {
    private final Map<String, Set<Food>> products = new HashMap<>();

    @Override
    public Map<String, Set<Food>> get() {
        return new HashMap<>(products);
    }

    @Override
    public boolean accept(Food food) {
        return ProductControlDate.percentComplete(food.getCreateDate(), food.getExpireDate()) < 25;
    }

    @Override
    public boolean add(List<Food> foodList) {
        boolean result = false;
        for (Food food : foodList) {
            result = products.computeIfAbsent(food.getCategory(), value -> new HashSet<>()).add(food);
        }
        return result;
    }
}
