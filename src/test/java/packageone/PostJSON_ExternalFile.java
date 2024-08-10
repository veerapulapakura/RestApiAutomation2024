package packageone;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostJSON_ExternalFile {

    @Test(priority =2)
    public void postData() throws FileNotFoundException {

        File file = new File("/Users/veerapulapakura/Desktop/RestApiAutomation/body.json");

        FileReader fr = new FileReader(file);
        JSONTokener jt =new JSONTokener(fr);
        JSONObject data =new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("Ratna"))
                .body("cources[1]",equalTo("English"))
                .body("cources[0]",equalTo("Telugu"))
                .log().all();

    }
}
