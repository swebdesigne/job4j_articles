package ood.srp.designe.srp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TypeSalary implements EstablishSalary {
    private final double SALARY;

    public TypeSalary(double salary) {
        this.SALARY = salary;
    }

    @Override
    public double salaryWithPremium(int percent) {
        return SALARY + (SALARY * percent) / 100;
    }

    @Override
    public double salaryWithDeduction(int percent) {
        return new BigDecimal(SALARY - (SALARY * percent) / 100)
                .setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
