package ood.lsp.food.manage.relocate;

import ood.lsp.food.products.Food;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface IConditionRelocate {
    Predicate<Food> check(LocalDate now,  int... prop);
}
