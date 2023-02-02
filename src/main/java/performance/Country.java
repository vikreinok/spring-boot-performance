package performance;

public enum Country {

    DE,
    CH;

    public static Country fromString(String country) {
        return Country.valueOf(country.toUpperCase());
    }
}
