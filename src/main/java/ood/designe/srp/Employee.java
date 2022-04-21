package ood.designe.srp;

import javax.xml.bind.annotation.*;
import java.util.Calendar;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", hired=" + hired
                + ", fired=" + fired
                + ", salary=" + salary
                + '}';
    }

    static class Builder {
        private String name;
        private Calendar hired;
        private Calendar fired;
        private double salary;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildHired(Calendar hired) {
            this.hired = hired;
            return this;
        }

        Builder buildFired(Calendar fired) {
            this.fired = fired;
            return this;
        }

        Builder buildSalary(double salary) {
            this.salary = salary;
            return this;
        }

        Employee build() {
            Employee employee = new Employee();
            employee.name = name;
            employee.hired = hired;
            employee.fired = fired;
            employee.salary = salary;
            return employee;
        }
    }
}
