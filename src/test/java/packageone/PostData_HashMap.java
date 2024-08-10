package packageone;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostData_HashMap {

    @Test(priority =2)
    public void postData(){

        HashMap data = new HashMap();
        data.put("name", "Ratna");
        data.put("Job", "Computers");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();

    }
}
