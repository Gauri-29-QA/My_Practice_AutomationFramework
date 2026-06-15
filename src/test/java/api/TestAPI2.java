package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestAPI2 {

    @Test
    public void testApi2()
    {
        String url="https://jsonplaceholder.typicode.com/users/1";

         given().
                when().get(url)
                .then().statusCode(200)
                 .body("id", equalTo(1))
                 .body("name", notNullValue())
                 .body("email", containsString("@"));

    }
}
