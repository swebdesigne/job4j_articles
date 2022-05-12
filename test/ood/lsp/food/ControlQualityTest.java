package ood.lsp.food;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControlQualityTest {
    @Test
    public void addToWarehouse() {
        LocalDate now = LocalDate.now();
        List<Food> food = List.of(new Banana("Banana Warehouse", 40D, 10, "Banana", now.minusDays(2), now.plusDays(9)));
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse()));
        assertTrue(controlQuality.execute(food));
    }

    @Test
    public void addToShop() {
        LocalDate now = LocalDate.now();
        List<Food> food = List.of(new Banana("Banana Shop", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17)));
        ControlQuality controlQuality = new ControlQuality(List.of(new Shop()));
        assertTrue(controlQuality.execute(food));
    }

    @Test
    public void addToTrash() {
        LocalDate now = LocalDate.now();
        List<Food> food = List.of(new Banana("Banana Trash", 100D, 30, "Banana", now, now));
        ControlQuality controlQuality = new ControlQuality(List.of(new Trash()));
        assertTrue(controlQuality.execute(food));
    }

    @Test
    public void findAll() {
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage shop = new Shop();
        List<Food> food = List.of(
                new Ananas("Ananas", 100D, 30, "Ananas", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana", 75D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17))
        );
        ControlQuality controlQuality = new ControlQuality(List.of(shop));
        controlQuality.execute(food);
        List<Food> expected = finder.findAll(shop.get());
        assertEquals(food, expected);
    }

    @Test
    public void findByCategory() {
        LocalDate now = LocalDate.now();
        FinderFood finder = new FinderFood();
        IStorage shop = new Shop();
        List<Food> food = List.of(
                new Banana("Banana", 75D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Banana("Banana", 70D, 20, "Banana", now.minusDays(13), now.plusDays(17)),
                new Ananas("Ananas", 100D, 30, "Ananas", now.minusDays(13), now.plusDays(17))
        );
        ControlQuality controlQuality = new ControlQuality(List.of(shop));
        controlQuality.execute(food);
        List<Food> expected = finder.findByCategory(shop.get(), "Banana");
        assertEquals(List.of(food.get(0), food.get(1)), expected);
    }

    @Test
    public void findByName() {
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
        new ControlQuality(List.of(shop, warehouse, trash)).execute(food);
        List<Food> expected = List.of(
                finder.findByName(warehouse.get(), "Banana Warehouse").get(0),
                finder.findByName(shop.get(), "Banana Shop").get(0),
                finder.findByName(trash.get(), "Banana Trash").get(0)
        );
        assertEquals(food, expected);
    }

    @Test
    public void whenAddToShopWithDiscount() {
        LocalDate now = LocalDate.now();
        IStorage shop = new Shop();
        List<Food> food = List.of(
                new Banana("Banana Shop with discount", 100D, 30, "Banana", now.minusDays(9), now.plusDays(2))
        );
        ControlQuality controlQuality = new ControlQuality(List.of(shop));
        controlQuality.execute(food);
        Food expected = new Banana("Banana Shop with discount", 70D, 30, "Banana", now.minusDays(9), now.plusDays(2));
        Food getFood = new FinderFood().findByName(shop.get(), "Banana Shop with discount").get(0);
        assertEquals(getFood, expected);
    }
}