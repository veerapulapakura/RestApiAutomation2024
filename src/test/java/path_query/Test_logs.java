package path_query;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import java.util.Map;

public class Test_logs {

    @Test(priority =2)
    public void BodyOnly(){
        //Response res = RestAssured.get("https://www.google.com/");
        given()
                .get("https://www.google.com/")
                .then()
                .log().body()
                .log().cookies()
                .log().headers();
    }
}
