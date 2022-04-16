package ood.designe.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee.Builder()
                .buildName("Ivan")
                .buildHired(now)
                .buildFired(now)
                .buildSalary(100)
                .build();
        store.add(worker);
        Report engine = new ReportEngine(new ReportToString(store));
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee.Builder()
                .buildName("Ivan")
                .buildHired(now)
                .buildFired(now)
                .buildSalary(100)
                .build();
        store.add(worker);
        Report engine = new ReportEngine(new ReportToHTML(store));
        StringBuilder expect = new StringBuilder();
        expect.append("<tr>")
                .append("<th>Name;</th>")
                .append("<th>Salary;</th>");
        expect.append("</tr>");
        expect.append("<tr>");
        expect.append("<td>").append(worker.getName()).append(";").append("</td>");
        expect.append("<td>").append(worker.getSalary()).append(";").append("</td>");
        expect.append("</tr>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenEstablishedPremiumToSalary() {
        Employee employee = new Employee.Builder()
                .buildName("Igor")
                .buildHired(Calendar.getInstance())
                .buildFired(Calendar.getInstance())
                .buildSalary(new TypeSalary(40.3).salaryWithPremium(10))
                .build();
        assertThat(employee.getSalary(), is(44.33));
    }

    @Test
    public void whenDeductionFromSalary() {
        Employee employee = new Employee.Builder()
                .buildName("Igor")
                .buildHired(Calendar.getInstance())
                .buildFired(Calendar.getInstance())
                .buildSalary(new TypeSalary(40.3).salaryWithDeduction(10))
                .build();
        assertThat(employee.getSalary(), is(36.27));
    }

    @Test
    public void reportHR() {
        MemStore store = new MemStore();
        Employee worker1 = new Employee.Builder().buildName("Igor").buildSalary(40).build();
        Employee worker2 = new Employee.Builder().buildName("Boris").buildSalary(30).build();
        Employee worker3 = new Employee.Builder().buildName("Alina").buildSalary(20).build();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder();
        expect.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true), is(expect.toString()));
    }
}