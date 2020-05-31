package rates.api.model;

import io.restassured.response.ValidatableResponse;


public class ScenarioData {

    private Request request = new Request();
    private ValidatableResponse response;

    public Request getRequest() {
        return this.request;
    }

    public ValidatableResponse getResponse() {
        return this.response;
    }

    public void setResponse(ValidatableResponse response) {
        this.response = response;
    }
}
