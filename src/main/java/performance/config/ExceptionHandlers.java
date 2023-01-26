package performance.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import performance.exception.CountryNotDefinedException;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(CountryNotDefinedException.class)
    public ResponseEntity<?> handle(CountryNotDefinedException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}