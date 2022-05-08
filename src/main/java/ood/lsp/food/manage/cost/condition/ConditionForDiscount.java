package ood.lsp.food.manage.cost.condition;

import ood.lsp.food.products.Food;
import ood.lsp.food.manage.date.ProductControlDate;

import java.time.LocalDate;
import java.util.function.Predicate;

public class ConditionForDiscount implements ICondition {
    private final ProductControlDate controlDate = new ProductControlDate();

    @Override
    public Predicate<Food> check(LocalDate now, int bound) {
        return product -> controlDate.todayIsMoreHighBoundDateAndLessExpireDate(
                now, product.getCreateDate(), product.getExpireDate(), bound);
    }
}
