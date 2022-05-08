package ood.lsp.food;

import ood.lsp.food.manage.cost.Discount;
import ood.lsp.food.manage.cost.condition.ConditionForDiscount;
import ood.lsp.food.manage.relocate.ConditionForJob;
import ood.lsp.food.manage.relocate.ConditionForTrash;
import ood.lsp.food.manage.relocate.ConditionForWarehouse;
import ood.lsp.food.products.Ananas;
import ood.lsp.food.products.Banana;
import ood.lsp.food.products.Food;
import ood.lsp.food.storage.IStorage;
import ood.lsp.food.storage.Shop;
import ood.lsp.food.storage.Trash;
import ood.lsp.food.storage.Warehouse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class ControlQualityTest {
    @Test
    public void addToWarehouse() {
        int lowBound = 25;
        int highBound = 75;
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage warehouse = new Warehouse();
        List<Food> food = List.of(new Banana("Banana Warehouse", 40D, 10, "Banana", now.minusDays(2), now.plusDays(9)));
        Map<Predicate<Food>, IStorage> map = Map.of(new ConditionForWarehouse().check(now, lowBound), warehouse);
        ControlQuality controlQuality = new ControlQuality(food, map);
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        List<Food> expected = List.of(finder.findByName(warehouse.get(), "Banana Warehouse").get(0));
        assertEquals(food, expected);
    }

    @Test
    public void addToShop() {
        int lowBound = 25;
        int highBound = 75;
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage shop = new Shop();
        List<Food> food = List.of(new Banana("Banana Shop", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17)));
        Map<Predicate<Food>, IStorage> map = Map.of(new ConditionForJob().check(now, lowBound), shop);
        ControlQuality controlQuality = new ControlQuality(food, map);
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        List<Food> expected = List.of(finder.findByName(shop.get(), "Banana Shop").get(0));
        assertEquals(food, expected);
    }

    @Test
    public void addToTrash() {
        int highBound = 75;
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage trash = new Trash();
        List<Food> food = List.of(new Banana("Banana Trash", 100D, 30, "Banana", now, now));
        Map<Predicate<Food>, IStorage> map = Map.of(new ConditionForTrash().check(now), trash);
        ControlQuality controlQuality = new ControlQuality(food, map);
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        List<Food> expected = List.of(finder.findByName(trash.get(), "Banana Trash").get(0));
        assertEquals(food, expected);
    }

    @Test
    public void findAll() {
        int lowBound = 25;
        int highBound = 75;
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage shop = new Shop();
        List<Food> food = List.of(
                new Ananas("Ananas", 100D, 30, "Ananas", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana", 75D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17))
        );
        Map<Predicate<Food>, IStorage> map = Map.of(new ConditionForJob().check(now, lowBound), shop);
        ControlQuality controlQuality = new ControlQuality(food, map);
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        List<Food> expected = finder.findAll(shop.get());
        assertEquals(food, expected);
    }

    @Test
    public void findByCategory() {
        int lowBound = 25;
        int highBound = 75;
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage shop = new Shop();
        List<Food> food = List.of(
                new Banana("Banana", 75D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Ananas("Ananas", 100D, 30, "Ananas", now.minusDays(13), now.plusDays(17))
        );
        Map<Predicate<Food>, IStorage> map = Map.of(new ConditionForJob().check(now, lowBound), shop);
        ControlQuality controlQuality = new ControlQuality(food, map);
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        List<Food> expected = finder.findByCategory(shop.get(), "Banana");
        assertEquals(List.of(food.get(0), food.get(1)), expected);
    }

    @Test
    public void findByName() {
        int lowBound = 25;
        int highBound = 75;
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage shop = new Shop();
        IStorage trash = new Trash();
        IStorage warehouse = new Warehouse();
        List<Food> food = List.of(
                new Banana("Banana Warehouse", 40D, 10, "Banana", now.minusDays(2), now.plusDays(9)),
                new Banana("Banana Shop", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana Trash", 100D, 30, "Banana", now, now)
        );
        Map<Predicate<Food>, IStorage> map = Map.of(
                new ConditionForWarehouse().check(now, lowBound), warehouse,
                new ConditionForJob().check(now, lowBound), shop,
                new ConditionForTrash().check(now), trash
        );
        ControlQuality controlQuality = new ControlQuality(food, map);
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        List<Food> expected = List.of(
                finder.findByName(warehouse.get(), "Banana Warehouse").get(0),
                finder.findByName(shop.get(), "Banana Shop").get(0),
                finder.findByName(trash.get(), "Banana Trash").get(0)
        );
        assertEquals(food, expected);
    }

    @Test
    public void whenAddToShopWithDiscount() {
        int lowBound = 25;
        int highBound = 75;
        LocalDate now = LocalDate.now();
        IStorage shop = new Shop();
        List<Food> food = List.of(
                new Banana("Banana Shop with discount", 100D, 30, "Banana", now.minusDays(9), now.plusDays(2))
        );
        ControlQuality controlQuality = new ControlQuality(food, Map.of(new ConditionForJob().check(now, lowBound), shop));
        controlQuality.execute(new ConditionForDiscount().check(now, highBound), new Discount());
        Food expected = new Banana(
                "Banana Shop with discount", 70D, 30, "Banana", now.minusDays(9), now.plusDays(2)
        );
        Food getFood = new FinderFood().findByName(shop.get(), "Banana Shop with discount").get(0);
        assertEquals(getFood, expected);
    }
}