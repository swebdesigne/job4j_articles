package ood.designe.srp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TypeSalary implements EstablishSalary {
    private final double salary;

    public TypeSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double salaryWithPremium(int percent) {
        return salary + (salary * percent) / 100;
    }

    @Override
    public double salaryWithDeduction(int percent) {
        return new BigDecimal(salary - (salary * percent) / 100)
                .setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
