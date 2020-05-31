package rates.api.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import rates.api.operation.DateRetriever;

import java.time.*;
import java.time.format.DateTimeFormatter;



@RunWith(JUnitParamsRunner.class)
public class DateRetrieverTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Parameters({
            "2020-05-31,2020-05-29",
            "2020-05-30,2020-05-29",
            "2020-05-29,2020-05-29"
    })
    @Test
    public void shouldRetrieveLastWorkingDay(String actualDate, String expectedDate) {
        LocalDate date = LocalDate.parse(actualDate, formatter);
        ZonedDateTime actualZoneDate = date.atStartOfDay(ZoneId.of("UTC"));
        assertThat(DateRetriever.getLastWorkingDate(actualZoneDate), equalTo(expectedDate));
    }


}
