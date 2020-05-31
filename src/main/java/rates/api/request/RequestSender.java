package rates.api.request;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

@Component
public class RequestSender {

    public RequestSender() {
    }

    public ValidatableResponse sendRequest(RequestSpecification requestSpecification, Method httpMethod){
        return RestAssured.given().config(createConfigWithNumberReturnType()).spec(requestSpecification).log().all().request(httpMethod).then().log().all();
    }

    private RestAssuredConfig createConfigurationWithTimeout(){
        return RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 15000).setParam("http.socket.timeout", 15000));
    }

    private RestAssuredConfig createConfigWithNumberReturnType(){
        return RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL));
    }
}
