package ood.lsp.food;


import ood.lsp.food.products.Food;
import ood.lsp.food.storage.IStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ControlQuality {
    private final List<IStorage> storages;

    public ControlQuality(List<IStorage> storages) {
        this.storages = storages;
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (IStorage storage : storages) {
            for (Set<Food> food : storage.get().values()) {
                foods.addAll(food);
            }
            storage.clear();
        }
        execute(foods);
    }

    public boolean execute(List<Food> foods) {
        for (IStorage storage : storages) {
            for (Food food : foods) {
                if (storage.accept(food)) {
                    if (!storage.add(food)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
