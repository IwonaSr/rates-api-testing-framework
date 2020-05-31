package rates.api.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class Response {

    private Map<String, String> headers;
    private String status;
    private JsonNode payload;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getStatus() {
        return status;
    }

    public JsonNode getPayload() {
        return payload;
    }
}
