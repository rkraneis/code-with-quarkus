package org.acme.lambda;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class LambdaHandlerTest {

    @Test
    public void testSimpleLambdaSuccess() throws Exception {
        // you test your lambas by invoking on http://localhost:8081
        // this works in dev mode too
        
        RestAssured.port = 8082;

        Person in = new Person();
        in.setName("Stu");
        given()
                .contentType("application/json")
                .accept("application/json")
                .body(in)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body(containsString("Hello Stu"));
    }

}
