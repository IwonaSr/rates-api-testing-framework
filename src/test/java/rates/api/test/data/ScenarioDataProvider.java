package rates.api.test.data;

import cucumber.api.Scenario;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.core.Serenity;
import rates.api.model.Request;
import rates.api.model.ScenarioData;

public class ScenarioDataProvider {

    private Scenario scenario;

    public ScenarioDataProvider() {
    }

    public void init(Scenario scenario){
        this.scenario = scenario;
        if(!Serenity.hasASessionVariableCalled(scenario)){
            Serenity.getCurrentSession().put(scenario, new ScenarioData());
        }
    }

    public void removeData(){
        Serenity.getCurrentSession().remove(this.scenario);
    }

    private ScenarioData getScenarioData() {
        return Serenity.sessionVariableCalled(this.scenario);
    }

    public Request getRequest(){
        return this.getScenarioData().getRequest();
    }

    public ValidatableResponse getResponse(){
        return this.getScenarioData().getResponse();
    }

    public void setResponse(ValidatableResponse response){
        this.getScenarioData().setResponse(response);
    }

}
