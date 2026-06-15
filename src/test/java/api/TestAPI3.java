package api;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestAPI3 {

    @Test
    public void testApi3()
    {
        String url="https://jsonplaceholder.typicode.com/users/1";

       Response rs= given()
                .when().get(url);

       var json=rs.jsonPath();
        String name=json.getString("name");
        String email=json.getString("email");
        String userName=json.getString("username");
        int userId=json.getInt("id");

        System.out.println(name);
        System.out.println(email);
        System.out.println(userName);
        System.out.println("Status Code: "+rs.statusCode());
        System.out.println("Response time: "+rs.getTime());

        if (rs.statusCode()==200)
        {
            System.out.println("PASS");
        }else
        {
            System.out.println("FAIL");
        }
        String nexrURL="https://jsonplaceholder.typicode.com/users/"+userId;
        Response rs2= given()
                .when().get(nexrURL);
        System.out.println(rs2.statusCode());
        System.out.println(rs2.jsonPath().getString("name"));
    }
}
