package ood.lsp.food.storage;

import ood.lsp.food.products.Food;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IStorage {
    boolean accept(Food food);
    Map<String, Set<Food>> get();
    boolean add(Food food);
}
