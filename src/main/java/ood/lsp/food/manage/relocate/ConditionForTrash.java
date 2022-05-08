package ood.lsp.food.manage.relocate;

import ood.lsp.food.products.Food;
import ood.lsp.food.manage.date.ProductControlDate;

import java.time.LocalDate;
import java.util.function.Predicate;

public class ConditionForTrash implements IConditionRelocate {
    private final ProductControlDate controlDate = new ProductControlDate();

    @Override
    public Predicate<Food> check(LocalDate now, int... prop) {
        return food -> !controlDate.createDateIsBeforeExpireDate(food.getCreateDate(), food.getExpireDate());
    }
}
