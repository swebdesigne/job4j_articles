package ood.srp.designe.srp;

import java.util.function.Predicate;

public class ReportEngine<T> implements Report<T> {
    private Report report;

    public ReportEngine(Report report) {
        this.report = report;
    }

    @Override
    public T generate(Predicate<Employee> filter) {
        return (T) report.generate(filter);
    }
}
