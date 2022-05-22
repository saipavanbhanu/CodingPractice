package java8.joda.timeapi;

import java.time.*;

public class JodaTimeApiUsage {
    public static void main(String [] args ){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        int dd = date.getDayOfMonth();
        int mm = date.getMonthValue();
        int yyyy = date.getYear();
        System.out.println("dd-mm-yyyy :: "+dd+"-"+mm+"-"+yyyy);

        LocalTime time = LocalTime.now();
        System.out.println(time);
        int h = time.getHour();
        int m = time.getMinute();
        int s = time.getSecond();
        int n = time.getNano();
        System.out.println(h+":"+m+":"+s+":"+n);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime dt1 = LocalDateTime.of(1995, Month.APRIL,28,12,45);
        System.out.println(dt1);

        dt1 = LocalDateTime.of(1995, 4,28,12,45);
        System.out.println(dt1);

        dt1=LocalDateTime.of(1995,04,28,12,45);
        System.out.println(dt1.plusMonths(6));
        System.out.println(dt1.minusMonths(6));

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1993,12,15);
        Period p = Period.between(birthday,today);
        System.out.printf("age is %d year %d months %d days\n",p.getYears(),p.getMonths(),p.getDays());

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId la = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zt = ZonedDateTime.now(la);
        System.out.println(zt);
    }
}
