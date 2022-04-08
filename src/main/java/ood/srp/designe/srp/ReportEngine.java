package ood.srp.designe.srp;

import java.util.function.Predicate;

public class ReportEngine<T> implements Report<T> {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public T generate(Predicate<Employee> filter) {
        return (T) new ReportToString(store).generate(filter);
    }
}
