package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class TestAPI4 {

    @Test
    public void testApi4()
    {
        String url="https://jsonplaceholder.typicode.com/posts";
        String requestBody = "{\n" +
                "\"userId\":1,\n" +
                "\"title\":\"qui est esse\",\n" +
                "\"body\":\"sample body\"\n" +
                "}";
        Response rs=given()
                .header("Content-Type","application/json")
                .body(requestBody).when().post(url);

        System.out.println("Status Code: " + rs.statusCode());

        System.out.println(rs.asString());

        var jsonBody=rs.jsonPath();
        int id=jsonBody.getInt("id");
        System.out.println(id);

//----------------------------------------------------------------------------------------------------------------//
        String url2="https://jsonplaceholder.typicode.com/posts/1";
        String requestBody2 =
                "{\n" +
                        "\"id\":1,\n" +
                        "\"userId\":1,\n" +
                        "\"title\":\"Updated Title\",\n" +
                        "\"body\":\"Updated Body\"\n" +
                        "}";
        Response rs2=given()
                .header("Content-Type","application/json")
                .body(requestBody2).when().put(url2);
        JsonPath jsonbody=rs2.jsonPath();
        System.out.println("Status Code: " + rs2.statusCode());
        System.out.println(rs2.asString());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(rs2.statusCode(),200);
        softAssert.assertEquals(jsonbody.getString("title"),"Updated Title");
        softAssert.assertEquals(jsonbody.getString("body"),"Updated Body");

//----------------------------------------------------------------------------------------------------------------//
        String requestBody3 =
                "{\n" +
                        "\"title\":\"New Patched Title\"\n" +
                        "}";
        Response rs3=given()
                .header("Content-Type","application/json")
                .body(requestBody3).when().patch(url2);

        System.out.println("Status Code: " + rs3.statusCode());
        System.out.println(rs3.asString());

        softAssert.assertAll();
    }
}
