package rates.api.test.definitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import rates.api.operation.DateRetriever;
import rates.api.test.configuration.TestConfiguration;
import rates.api.test.data.FieldNames;
import rates.api.test.data.ScenarioDataProvider;
import rates.api.test.steps.ResponseSteps;

import java.util.List;

@ContextConfiguration(classes = {TestConfiguration.class})
public class ResponseStepsDefinition {

    @Value("#{'${currencies.names}'.split(',')}")
    private List<String> countries;

    @Steps(shared = true)
    ScenarioDataProvider scenarioDataProvider;

    @Steps(shared = true)
    ResponseSteps responseSteps;

    @Before
    public void setUp(Scenario scenario) {
        scenarioDataProvider.init(scenario);
    }

    @Then("Response status is {int}")
    public void responseStatusIs(int status) {
        responseSteps.assertResponseStatus(scenarioDataProvider.getResponse(), status);
    }

    @And("All countries rates are returned \\(without Euro)")
    public void allCountriesRatesAreReturnedWithoutEuro() {
        responseSteps.checkIfAllCountriesAreReturned(scenarioDataProvider.getResponse(), FieldNames.RATES_FIELD.getValue(), countries);
    }

    @Then("Field {string} is {string}")
    public void baseIs(String fieldPath, String expectedValue) {
        responseSteps.assertThatBodyHasFieldWithExactValue(scenarioDataProvider.getResponse(),fieldPath,expectedValue );
    }

    @And("Field date has last working UTC date")
    public void fieldDateHasLastWorkingUTCDate() {
        responseSteps.assertDateIsLastWorkingDay(scenarioDataProvider.getResponse(), DateRetriever.getLastWorkingDate(DateRetriever.getActualDate()));
    }

    @And("Rates {string} have correct precision")
    public void ratesHasCorrectFormat(String fieldPath) {
        if (fieldPath.equals("rates")) {
            responseSteps.assertThatAllCountriesHaveCorrectRatesValue(scenarioDataProvider.getResponse(), fieldPath);
        }else{
            responseSteps.assertThatHasCorrectRateValue(scenarioDataProvider.getResponse(), fieldPath);
        }
    }
}
