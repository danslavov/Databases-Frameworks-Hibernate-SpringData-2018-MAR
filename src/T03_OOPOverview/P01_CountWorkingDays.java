package T03_OOPOverview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class P01_CountWorkingDays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate firstDate = LocalDate.parse(reader.readLine(), dtf);
        LocalDate secondDate = LocalDate.parse(reader.readLine(), dtf);
        int workingDays = 0;

        LocalDate[] holidays = new LocalDate[]{
                LocalDate.parse("01-01-2000", dtf),
                LocalDate.parse("03-03-2000", dtf),
                LocalDate.parse("01-05-2000", dtf),
                LocalDate.parse("06-05-2000", dtf),
                LocalDate.parse("24-05-2000", dtf),
                LocalDate.parse("06-09-2000", dtf),
                LocalDate.parse("22-09-2000", dtf),
                LocalDate.parse("01-11-2000", dtf),
                LocalDate.parse("24-12-2000", dtf),
                LocalDate.parse("25-12-2000", dtf),
                LocalDate.parse("26-12-2000", dtf)
        };

        LocalDate today = firstDate;

        do {
            DayOfWeek dayOfWeek = today.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                today = today.plusDays(1);
                continue;
            }

            int day = today.getDayOfMonth();
            Month month = today.getMonth();
            boolean isHoliday = false;
            for (LocalDate h : holidays) {
                Month hMonth = h.getMonth();
                int hDay = h.getDayOfMonth();
                if (month == hMonth && day == hDay) {
                    isHoliday = true;
                    break;
                }
            }

            if (!isHoliday) {
                workingDays++;
            }
            today = today.plusDays(1);

        } while (!today.isEqual(secondDate.plusDays(1)));

        System.out.println(workingDays);
    }
}