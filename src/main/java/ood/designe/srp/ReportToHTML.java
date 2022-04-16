package ood.designe.srp;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ReportToHTML implements Report<String> {
    private Store store;

    public ReportToHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        Collections.sort(employees, Employee::compareTo);
        text.append("<tr>")
                .append("<th>Name;</th>")
                .append("<th>Salary;</th>");
        text.append("</tr>");
        for (Employee employee : employees) {
            text.append("<tr>");
            text.append("<td>").append(employee.getName()).append(";").append("</td>");
            text.append("<td>").append(employee.getSalary()).append(";").append("</td>");
            text.append("</tr>");
        }
        return text.toString();
    }
}
