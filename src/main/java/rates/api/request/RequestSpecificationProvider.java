package rates.api.request;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;
import rates.api.model.Request;

import java.util.Optional;

@Component
public class RequestSpecificationProvider {

    public RequestSpecificationProvider() {
    }

    public RequestSpecification createRequest(Request request){
        return RestAssured.given().baseUri(request.getBaseUri()).basePath(request.getResourcePath()).headers(request.getHeaders()).pathParams(request.getPathParameters()).queryParams(request.getQueryParameters()).body(Optional.ofNullable(request.getPayload()).map(JsonNode::toString).orElse(""));
    }
}