package ood.lsp.food;

import ood.lsp.food.products.Food;

import java.util.*;
import java.util.stream.Collectors;

public class FinderFood {
    public List<Food> findAll(Map<String, Set<Food>> products) {
        return products.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toList());
    }

    public List<Food> findByCategory(Map<String, Set<Food>> products, String name) {
        return products.entrySet().stream()
                .filter(key -> key.getKey().equals(name))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toList());
    }

    public List<Food> findByName(Map<String, Set<Food>> products, String name) {
        return products.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .filter(food -> food.getName().equals(name))
                .collect(Collectors.toList());
    }
}
