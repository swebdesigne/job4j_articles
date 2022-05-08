package ood.lsp.food;


import ood.lsp.food.manageCost.IManageCost;
import ood.lsp.food.products.Food;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ControlQuality {
    private List<Food> foodList;
    private Map<Predicate<Food>, IControlQuality> foodMap;

    public ControlQuality(List<Food> foodList, Map<Predicate<Food>, IControlQuality> foodMap) {
        this.foodList = foodList;
        this.foodMap = foodMap;
    }

    public void execute(Predicate<Food> conditionForDiscount, IManageCost manageCost) {
        for (Map.Entry<Predicate<Food>, IControlQuality> entry : foodMap.entrySet()) {
            entry.getValue().store(foodList.stream().filter(entry.getKey())
                    .map(product -> {
                                if (conditionForDiscount.test(product)) {
                                    product.setPrice(manageCost.setCost(product));
                                }
                                return product;
                            }
                    ).collect(Collectors.toList())
            );
        }
    }
}
