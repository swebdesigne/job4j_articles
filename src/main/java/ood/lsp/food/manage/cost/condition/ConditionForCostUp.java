package ood.lsp.food.manage.cost.condition;

import ood.lsp.food.products.Food;

import java.time.LocalDate;
import java.util.function.Predicate;

public class ConditionForCostUp implements ICondition {
    @Override
    public Predicate<Food> check(LocalDate now, int bound) {
        return null;
    }
}
