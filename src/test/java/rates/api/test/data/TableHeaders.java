package rates.api.test.data;

public enum TableHeaders {
    PARAMETER("Parameter"),
    VALUE("Value");

    private final String name;

    TableHeaders(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }
}
