package ood.lsp.food;


import ood.lsp.food.manage.cost.IManageCost;
import ood.lsp.food.products.Food;
import ood.lsp.food.storage.IStorage;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ControlQuality {
    private final List<Food> foodList;
    private final Map<Predicate<Food>, IStorage> foodMap;

    public ControlQuality(List<Food> foodList, Map<Predicate<Food>, IStorage> foodMap) {
        this.foodList = foodList;
        this.foodMap = foodMap;
    }

    public void execute(Predicate<Food> conditionForDiscount, IManageCost manageCost) {
        for (Map.Entry<Predicate<Food>, IStorage> entry : foodMap.entrySet()) {
            entry.getValue().add(foodList.stream().filter(entry.getKey())
                    .peek(product -> {
                                if (conditionForDiscount.test(product)) {
                                    product.setPrice(manageCost.setCost(product));
                                }
                            }
                    ).collect(Collectors.toList())
            );
        }
    }
}
