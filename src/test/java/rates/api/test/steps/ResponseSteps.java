package rates.api.test.steps;

import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import org.springframework.test.context.ContextConfiguration;
import rates.api.operation.RatePrecisionChecker;
import rates.api.test.configuration.TestConfiguration;
import rates.api.test.data.FieldNames;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.*;

@ContextConfiguration(classes = {TestConfiguration.class})
public class ResponseSteps {

    @Step
    public void assertResponseStatus(ValidatableResponse response, int expectedStatus) {
        response.statusCode(expectedStatus);
    }

    @Step
    public <T> void assertThatBodyHasFieldWithExactValue(ValidatableResponse response, String fieldPath, T value) {
        response.body(fieldPath, equalTo(value));
    }

    @Step
    public <T> void assertThatResponseHasEveryItemWithExpectedValue(ValidatableResponse response, String fieldPath, T value) {
        response.body(fieldPath, everyItem(equalTo(value)));
    }

    @Step
    public void checkIfAllCountriesAreReturned(ValidatableResponse response, String fieldPath, List<String> expectedCountries) {
        Map<String, BigDecimal> allCountriesRates = extractFieldValue(response, fieldPath);
        List<String> actualCountries = new ArrayList<>(allCountriesRates.keySet());
        Collections.sort(actualCountries);
        Collections.sort(expectedCountries);
        assertTrue(actualCountries.equals(expectedCountries));
    }

    public void assertThatAllCountriesHaveCorrectRatesValue(ValidatableResponse response, String fieldPath) {
        Map<String, BigDecimal> allCountriesRates = extractFieldValue(response, fieldPath);
        List<BigDecimal> ratesValues = new ArrayList<>(allCountriesRates.values());
        ratesValues.stream().forEach(rateValue -> RatePrecisionChecker.isCorrectPrecision(rateValue));
    }

    private <T> T extractFieldValue(ValidatableResponse response, String fieldPath) {
        return response.extract().body().jsonPath().get(fieldPath);
    }

    @Step
    public void assertDateIsLastWorkingDay(ValidatableResponse response, String expectedDate) {
        assertThatBodyHasFieldWithExactValue(response, FieldNames.DATE_FIELD.getValue(), expectedDate);
    }

    @Step
    public void assertThatHasCorrectRateValue(ValidatableResponse response, String fieldPath) {
        assertTrue(RatePrecisionChecker.isCorrectPrecision(extractFieldValue(response, fieldPath)));
    }
}
