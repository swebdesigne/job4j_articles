package ood.lsp.food;


import ood.lsp.food.products.Food;
import ood.lsp.food.storage.IStorage;

import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {
    private List<IStorage> storages;

    public ControlQuality(List<IStorage> storages) {
        this.storages = storages;
    }

    public boolean execute(List<Food> foods) {
        boolean result = false;
        for (IStorage storage : storages) {
            result |= storage.add(foods.stream().filter(food -> storage.accept(food)).collect(Collectors.toList()));
        }
        return result;
    }
}
