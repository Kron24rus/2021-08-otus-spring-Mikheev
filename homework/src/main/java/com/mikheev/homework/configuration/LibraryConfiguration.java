package com.mikheev.homework.configuration;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.mikheev.homework.repositories.AuthorRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongock
@EnableMongoRepositories(basePackageClasses = AuthorRepository.class)
@Configuration
public class LibraryConfiguration {

//    @Bean
//    public FilterRegistrationBean spaRedirectFiler() {
//        FilterRegistrationBean<OncePerRequestFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(createRedirectFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("frontendRedirectFiler");
//        registration.setOrder(1);
//        return registration;
//    }
//
//    private OncePerRequestFilter createRedirectFilter() {
//        return new OncePerRequestFilter() {
//            // Forwards all routes except '/index.html', '/api/library/', '/api/library/**' (caused by history API on frontend)
//            private final String REGEX = "(?!/api/library|/static|/index\\.html|/favicon\\.ico).*$";
//            private Pattern pattern = Pattern.compile(REGEX);
//            @Override
//            protected void doFilterInternal(ServerRequest request, ServerResponse response,
//                                            WebFilterChain filterChain) throws IOException {
//                if (pattern.matcher(request.requestPath().toString()).matches() && !request.requestPath().contextPath().equals("/")) {
//                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
//                    requestDispatcher.forward(request, response);
//                } else {
//                    filterChain.doFilter(request, response);
//                }
//            }
//        };
//    }
}
