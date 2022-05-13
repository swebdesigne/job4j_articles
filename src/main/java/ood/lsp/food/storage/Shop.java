package ood.lsp.food.storage;

import ood.lsp.food.manage.cost.Discount;
import ood.lsp.food.manage.date.ProductControlDate;
import ood.lsp.food.products.Food;

import java.util.*;

public class Shop implements IStorage {
    private final Map<String, Set<Food>> products = new HashMap<>();

    @Override
    public Map<String, Set<Food>> get() {
        return new HashMap<>(products);
    }

    @Override
    public boolean accept(Food food) {
        return ProductControlDate.percentComplete(food.getCreateDate(), food.getExpireDate()) > 25
                && ProductControlDate.createDateIsBeforeExpireDate(food.getCreateDate(), food.getExpireDate());
    }

    @Override
    public boolean add(List<Food> foodList) {
        boolean result = false;
        for (Food food : foodList) {
            if (ProductControlDate.todayIsMoreHighBoundDateAndLessExpireDate(food.getCreateDate(), food.getExpireDate(), 75)) {
                food.setPrice(new Discount().setCost(food));
            }
            result = products.computeIfAbsent(food.getCategory(), value -> new HashSet<>()).add(food);
        }
        return result;
    }
}
