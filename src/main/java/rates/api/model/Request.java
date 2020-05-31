package rates.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class Request {

    private final Map<String, String> headers;
    private final Map<String, String> pathParameters;
    private Map<String, String> queryParameters;
    private String baseUri;
    private String resourcePath;
    private JsonNode payload;

    public Request() {
        this.headers = new TreeMap<>(CASE_INSENSITIVE_ORDER);
        this.pathParameters = new TreeMap<>(CASE_INSENSITIVE_ORDER);
        this.queryParameters = new TreeMap<>(CASE_INSENSITIVE_ORDER);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void addHeaders(Map<String, String> headers){
        this.headers.putAll(headers);
    }
    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void addPathParameters(Map<String, String> pathParameters){
        this.pathParameters.putAll(pathParameters);
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public void addQueryParameters(Map<String, String> queryParameters){
        this.queryParameters.putAll(queryParameters);
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public JsonNode getPayload() {
        return payload;
    }
}
