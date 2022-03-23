package ru.job4j.kiss;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MaxMinTest {

    @Test
    public void maxNumber() {
        int result = new MaxMin().max(List.of(1, 2, 3), Integer::compareTo);
        assertTrue(result == 3);
    }

    @Test
    public void minNumber() {
        int result = new MaxMin().min(List.of(1, 2, 3), Integer::compareTo);
        assertTrue(result == 1);
    }

    @Test
    public void maxString() {
        String result = new MaxMin().max(List.of("Alina", "Igor", "Boris"), String::compareTo);
        assertTrue(result.equals("Boris"));
    }

    @Test
    public void minString() {
        String result = new MaxMin().min(List.of("Alina", "Igor", "Boris"), String::compareTo);
        assertTrue(result.equals("Alina"));
    }
}