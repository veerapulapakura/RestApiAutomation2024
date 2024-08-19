package path_query;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Path_Query {
    @Test(priority =2)
    public void GetdataWithParams(){

        given()
                .pathParam("mypath", "users")
                .queryParam("id",5)
                .queryParam("page",2)
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
