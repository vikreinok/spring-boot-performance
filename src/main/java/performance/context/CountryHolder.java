package performance.context;

import performance.Country;

public class CountryHolder {

    private static final ThreadLocal<Country> country = new ThreadLocal<>();

    public static Country getCountry() {
        return country.get();
    }

    public static void setCountry(Country country) {
        CountryHolder.country.set(country);
    }

    public static void clear() {
        CountryHolder.country.remove();
    }

}
