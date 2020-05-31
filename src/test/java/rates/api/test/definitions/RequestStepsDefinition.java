package rates.api.test.definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import rates.api.test.data.ScenarioDataProvider;
import rates.api.test.configuration.TestConfiguration;
import rates.api.test.steps.RequestSteps;
import io.cucumber.datatable.DataTable;


import java.util.List;
import java.util.Map;


@ContextConfiguration(classes = {TestConfiguration.class})
public class RequestStepsDefinition {

    @Value("${rates.api.baseUri}")
    private String baseUri;

    @Steps(shared = true)
    ScenarioDataProvider scenarioDataProvider;

    @Steps(shared = true)
    RequestSteps requestSteps;

    @Before
    public void setUp(Scenario scenario) {
        scenarioDataProvider.init(scenario);
        scenarioDataProvider.getRequest().setBaseUri(baseUri);
    }

    @After
    public void tearDown() {
        scenarioDataProvider.removeData();
    }

    @Given("Request with resource path {string}")
    public void requestWithResourcePath(String resourcePath) {
        scenarioDataProvider.getRequest().setResourcePath(resourcePath);
    }

    @When("Request {string} is sent")
    public void requestIsSent(String httpMethod) {
        RequestSpecification requestSpecification = requestSteps.createRequest(scenarioDataProvider.getRequest());
        requestSteps.sendRequest(requestSpecification, Method.valueOf(httpMethod));
    }

    @And("Request path with following query parameters added")
    public void requestPathWithFollowingQueryParametersAdded(DataTable table) {
        List<Map<String, String>> queryParameters = table.asMaps(String.class, String.class);
        requestSteps.addQueryParameters(scenarioDataProvider.getRequest(), queryParameters);
    }

    @When("Request with following path parameters added")
    public void requestWithFollowingPathParametersAdded(DataTable table) {
        List<Map<String, String>> pathParameters = table.asMaps(String.class, String.class);
        requestSteps.addPathParameters(scenarioDataProvider.getRequest(), pathParameters);
    }
}
