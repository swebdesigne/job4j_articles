package ood.lsp.food;


import ood.lsp.food.products.Food;
import ood.lsp.food.storage.IStorage;

import java.util.List;

public class ControlQuality {
    private IStorage storage;

    public ControlQuality(IStorage storage) {
        this.storage = storage;
    }

    public boolean execute(List<Food> foods) {
        return storage.add(foods);
    }
}
