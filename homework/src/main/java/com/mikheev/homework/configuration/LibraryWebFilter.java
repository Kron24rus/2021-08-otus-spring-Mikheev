package com.mikheev.homework.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

@Component
public class LibraryWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String REGEX = "(?!/api/library|/static|/index\\.html|/favicon\\.ico).*$";
        Pattern pattern = Pattern.compile(REGEX);
        if (pattern.matcher(exchange.getRequest().getURI().getPath()).matches()
                && !exchange.getRequest().getURI().getPath().equals("/")) {
            return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/").build()).build());
        } else {
            return chain.filter(exchange);
        }
    }
}
