package com.mikheev.homework.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookControllerTest {

    @Autowired
    private RouterFunction<ServerResponse> route;

    @Test
    public void testRoute() {
        WebTestClient client = WebTestClient.bindToRouterFunction(route).build();

        client.get()
                .uri("/api/library/book")
                .exchange()
                .expectStatus()
                .isOk();
    }
}