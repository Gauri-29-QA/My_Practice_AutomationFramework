package api;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestAPI {
    @Test
    public void testApi1()
    {
        String url="https://jsonplaceholder.typicode.com/posts";

        given()
                .body("{ \"title\": \"QA Engineer\", \"body\": \"Learning API testing\", \"userId\": 10 }")
                .when()
                .post(url)
                .then()
                .statusCode(201);
    }
}
