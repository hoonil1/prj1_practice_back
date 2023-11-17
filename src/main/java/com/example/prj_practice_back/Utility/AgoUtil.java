package com.example.prj_practice_back.Utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgoUtil {
    public static String getAgo(LocalDateTime inserted, LocalDateTime now) {

        if (inserted.isBefore(now.minusYears(1))) {
            Period between = Period.between(inserted.toLocalDate(), now.toLocalDate());
            return between.get(ChronoUnit.YEARS) + "년 전";
        } else if (inserted.isBefore(now.minusMonths(1))) {
            Period between = Period.between(inserted.toLocalDate(), now.toLocalDate());
            return between.get(ChronoUnit.MONTHS) + "개월 전";
        } else if (inserted.isBefore(now.minusDays(1))) {
            Period between = Period.between(inserted.toLocalDate(), now.toLocalDate());
            return between.get(ChronoUnit.DAYS) + "일 전";
        } else if (inserted.isBefore(now.minusHours(1))) {
            Duration between = Duration.between(inserted, now);
            return (between.getSeconds()/60/60) + "시간 전";
        } else if (inserted.isBefore(now.minusMinutes(1))) {
            Duration between = Duration.between(inserted, now);
            return (between.getSeconds()/60) + "분 전";
        } else {
            Duration between = Duration.between(inserted, now);
            return between.getSeconds() + "초 전";
        }
    }
}
