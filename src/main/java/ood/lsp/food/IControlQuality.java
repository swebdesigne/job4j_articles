package ood.lsp.food;

import ood.lsp.food.products.Food;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IControlQuality {
    Map<String, Set<Food>> getProducts();
    void store(List<Food> food);
}
