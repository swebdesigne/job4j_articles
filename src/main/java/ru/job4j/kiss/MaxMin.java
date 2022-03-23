package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    private  <T> T comparing(List<T> value, BiPredicate<T, T> predicate) {
        T searchElement = value.get(0);
        for (T elem : value) {
            if (predicate.test(elem, searchElement)) {
                searchElement = elem;
            }
        }
        return searchElement;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comparing(value, (x, y) -> comparator.compare(x, y) == 1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comparing(value, (x, y) -> comparator.compare(x, y) == 0);
    }
}
