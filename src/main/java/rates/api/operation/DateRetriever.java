package rates.api.operation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.ZoneOffset.UTC;

public class DateRetriever {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    private DateRetriever(){
    }

    public static ZonedDateTime getActualDate(){
        ZonedDateTime currentDate = ZonedDateTime.now(UTC);
        return currentDate;
    }

    public static String getLastWorkingDate(ZonedDateTime date){
        return changeDateToLastWorkingDay(getDayOfWeek(date), date);
    }

    private static ZonedDateTime reverseDate(ZonedDateTime date, int days){
        return date.minus(days, ChronoUnit.DAYS);
    }

    private static String changeDateToLastWorkingDay(int dayOfWeek, ZonedDateTime actualDate){
        if(dayOfWeek == 6){
            actualDate = reverseDate(actualDate, 1);
        }else if(dayOfWeek == 7){
            actualDate =  reverseDate(actualDate, 2);
        }
        return actualDate.format(formatter);
    }

    private static int getDayOfWeek(ZonedDateTime date){
        return date.getDayOfWeek().getValue();
    }


}
