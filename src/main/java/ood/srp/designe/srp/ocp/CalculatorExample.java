package ood.srp.designe.srp.ocp;

import java.util.function.BiFunction;

public class CalculatorExample {
    private static class SimpleCalculator {
        public int sum(int a, int b) {
            return a + b;
        }
    }

    private static class AbstractCalculator<T> {
        public T calculate(BiFunction<T, T, T> function, T first, T second) {
            return function.apply(first, second);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CalculatorExample.SimpleCalculator().sum(1, 2));
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        System.out.println(new CalculatorExample.AbstractCalculator().calculate(biFunction, 1, 2));
    }
}
