package ood.srp.designe.srp;

import java.util.function.Predicate;

public interface Report<T> {
    T generate(Predicate<Employee> filter);
}
