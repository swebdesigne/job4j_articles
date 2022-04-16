package ood.designe.srp;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report<String> {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        Collections.sort(employees, Employee::compareTo);
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}