package ood.lsp.food.manage.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductControlDate {
    private LocalDate now = LocalDate.now();

    public long totalDays(LocalDate createDate, LocalDate expireDate) {
        return ChronoUnit.DAYS.between(createDate, expireDate);
    }

    public long elapsedDays(LocalDate now, LocalDate createDate) {
        return ChronoUnit.DAYS.between(createDate, now);
    }

    public float percentComplete(LocalDate createDate, LocalDate expireDate) {
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

    public boolean todayIsMoreHighBoundDateAndLessExpireDate(LocalDate createDate, LocalDate expireDate, int highBound) {
        return createDateIsBeforeExpireDate(createDate, expireDate) && percentComplete(createDate, expireDate) >= highBound;
    }
}
