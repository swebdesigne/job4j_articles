package ood.lsp.food.manageDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductControlDate {

    public long totalDays(LocalDate createDate, LocalDate expireDate) {
        return ChronoUnit.DAYS.between(createDate, expireDate);
    }

    public long elapsedDays(LocalDate now, LocalDate createDate) {
        return ChronoUnit.DAYS.between(createDate, now);
    }

    public float percentComplete(LocalDate now, LocalDate createDate, LocalDate expireDate) {
        try {
            return Math.abs((elapsedDays(now, createDate) * 100) / totalDays(createDate, expireDate));
        } catch (ArithmeticException e) {
            e.getStackTrace();
        }
        return 100;
    }

    public boolean createDateIsBeforeExpireDate(LocalDate createDate, LocalDate expireDate) {
        return createDate.isBefore(expireDate);
    }

    public boolean todayIsWithinRange(LocalDate now, LocalDate createDate, LocalDate expireDate) {
        return (!now.isBefore(createDate)) && now.isBefore(expireDate);
    }

    public boolean todayIsMoreHighBoundDateAndLessExpireDate(LocalDate now, LocalDate createDate, LocalDate expireDate, int highBound) {
        return createDateIsBeforeExpireDate(createDate, expireDate) && percentComplete(now, createDate, expireDate) >= highBound;
    }
}
