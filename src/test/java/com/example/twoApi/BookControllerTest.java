package com.example.twoApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @LocalServerPort
    private int port;

    RequestSpecification requestSpecification;

    @BeforeEach
    void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(port)
                .setBasePath("books")
                .build();
    }

    @Test
    void test1() {
        given()
                .log().all()
                .spec(requestSpecification)
                .get()
                .then()
                .statusCode(200)
                .log().all();
    }
}
