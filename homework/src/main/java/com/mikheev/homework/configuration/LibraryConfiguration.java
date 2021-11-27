package com.mikheev.homework.configuration;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@Configuration
public class LibraryConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    @Bean
    public FilterRegistrationBean spaRedirectFiler() {
        FilterRegistrationBean<OncePerRequestFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(createRedirectFilter());
        registration.addUrlPatterns("/*");
        registration.setName("frontendRedirectFiler");
        registration.setOrder(1);
        return registration;
    }

    private OncePerRequestFilter createRedirectFilter() {
        return new OncePerRequestFilter() {
            // Forwards all routes except '/index.html', '/api/library/', '/api/library/**' (caused by history API on frontend)
            private final String REGEX = "(?!/api/library|/static|/index\\.html|/favicon\\.ico).*$";
            private Pattern pattern = Pattern.compile(REGEX);
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain) throws ServletException, IOException {
                if (pattern.matcher(request.getRequestURI()).matches() && !request.getRequestURI().equals("/")) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
                    requestDispatcher.forward(request, response);
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        };
    }
}
