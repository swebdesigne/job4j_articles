package ood.designe.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportToJSON implements Report<String> {
    private Store store;

    public ReportToJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store.findBy(filter));
    }
}
