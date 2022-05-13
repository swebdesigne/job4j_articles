package ood.lsp.food.manage.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductControlDate {
    private static LocalDate now = LocalDate.now();

    public static long totalDays(LocalDate createDate, LocalDate expireDate) {
        return ChronoUnit.DAYS.between(createDate, expireDate);
    }

    public static long elapsedDays(LocalDate now, LocalDate createDate) {
        return ChronoUnit.DAYS.between(createDate, now);
    }

    public static float percentComplete(LocalDate createDate, LocalDate expireDate) {
        try {
            return Math.abs((elapsedDays(now, createDate) * 100) / totalDays(createDate, expireDate));
        } catch (ArithmeticException e) {
            e.getStackTrace();
        }
        return 100;
    }

    public static boolean createDateIsBeforeExpireDate(LocalDate createDate, LocalDate expireDate) {
        return createDate.isBefore(expireDate);
    }

    public static boolean createDateIsAfterExpireDate(LocalDate createDate, LocalDate expireDate) {
        return createDate.equals(expireDate) || createDate.isAfter(expireDate);
    }

    public static boolean todayIsWithinRange(LocalDate now, LocalDate createDate, LocalDate expireDate) {
        return (now.isAfter(createDate)) && now.isBefore(expireDate);
    }

    public static boolean todayIsMoreHighBoundDateAndLessExpireDate(LocalDate createDate, LocalDate expireDate, int highBound) {
        return createDateIsBeforeExpireDate(createDate, expireDate) && percentComplete(createDate, expireDate) >= highBound;
    }
}
