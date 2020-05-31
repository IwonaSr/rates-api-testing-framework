package rates.api.test.steps;

import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import rates.api.model.Request;
import rates.api.request.RequestSender;
import rates.api.request.RequestSpecificationProvider;
import rates.api.test.data.TableHeaders;
import rates.api.test.configuration.TestConfiguration;
import rates.api.test.data.ScenarioDataProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = {TestConfiguration.class})
public class RequestSteps {

    @Autowired
    private RequestSpecificationProvider requestSpecificationProvider;

    @Autowired
    private RequestSender requestSender;

    @Steps(shared = true)
    public ScenarioDataProvider scenarioDataProvider;

    @Step
    public RequestSpecification createRequest(Request request) {
        return requestSpecificationProvider.createRequest(request);
    }

    @Step
    public void addHeaders(Request request, Map<String, String> headers) {
        request.addHeaders(headers);
    }

    @Step
    public void sendRequest(RequestSpecification requestSpecification, Method method) {
        scenarioDataProvider.setResponse(requestSender.sendRequest(requestSpecification, method));
    }

    @Step
    public void addQueryParameters(Request request, List<Map<String, String>> parameters){
        request.addQueryParameters(convertListOfMapsToMap(parameters, TableHeaders.PARAMETER.getValue(),TableHeaders.VALUE.getValue()));
    }

    public void addPathParameters(Request request, List<Map<String, String>> parameters){
        request.addPathParameters(convertListOfMapsToMap(parameters, TableHeaders.PARAMETER.getValue(),TableHeaders.VALUE.getValue()));
    }

    private Map<String, String> convertListOfMapsToMap(List<Map<String, String>> parameters, String keyHeader, String keyValue){
        Map<String, String> queryParam = new HashMap();
        for (Map<String, String> map : parameters) {
            queryParam.put(map.get("Parameter"),(map.get("Value")));
        }
        return queryParam;
    }
}
