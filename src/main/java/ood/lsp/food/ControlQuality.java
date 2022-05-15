package ood.lsp.food;


import ood.lsp.food.products.Food;
import ood.lsp.food.storage.IStorage;

import java.util.List;

public class ControlQuality {
    private final List<IStorage> storages;

    public ControlQuality(List<IStorage> storages) {
        this.storages = storages;
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
