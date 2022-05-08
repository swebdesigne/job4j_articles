package ood.lsp.food.manageCost.condition;

import ood.lsp.food.products.Food;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface ICondition {
    Predicate<Food> check(LocalDate now, int bound);
}
