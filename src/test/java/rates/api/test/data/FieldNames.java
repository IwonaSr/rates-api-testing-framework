package rates.api.test.data;

public enum FieldNames {
    BASE_FIELD("base"),
    DATE_FIELD("date"),
    RATES_FIELD("rates");

    private final String name;

    FieldNames(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
