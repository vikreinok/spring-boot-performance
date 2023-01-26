package performance.exception;

public class CountryNotDefinedException extends RuntimeException {
    public CountryNotDefinedException(String message) {
        super(message);
    }
}
