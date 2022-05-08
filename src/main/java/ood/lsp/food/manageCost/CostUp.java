package ood.lsp.food.manageCost;

import ood.lsp.food.products.Food;

public class CostUp implements IManageCost {
    @Override
    public double setCost(Food food) {
        return food.getPrice() + (food.getPrice() * food.getDiscount()) / 100;
    }
}
