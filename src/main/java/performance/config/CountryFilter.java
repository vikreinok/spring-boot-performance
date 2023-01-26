package performance.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import performance.Country;
import performance.context.CountryHolder;
import performance.exception.CountryNotDefinedException;
import performance.exception.CountryNotSupportedException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class CountryFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        final String xCountryHeader = req.getHeader("X-country");

        // check if xCountryHeader is black and throw exception
        if (StringUtils.isEmpty(xCountryHeader)) {
            throw new CountryNotDefinedException("Header X-country is missing");
        }

        final Country country;
        try {
            country = Country.valueOf(xCountryHeader);
        } catch (IllegalArgumentException e) {
            throw new CountryNotSupportedException("Country not supported. " + xCountryHeader);
        }

        CountryHolder.setCountry(country);


        chain.doFilter(request, response);
    }
}