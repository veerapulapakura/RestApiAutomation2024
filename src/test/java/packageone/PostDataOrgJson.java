package packageone;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostDataOrgJson {

    @Test(priority =2)
    public void postData(){

        JSONObject data = new JSONObject();
        data.put("name", "Ratna");
        data.put("Job", "Computers");
        String Courses[] = {"Telugu","English"};
        data.put("Course",Courses);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("Ratna"))
                .body("Course[1]",equalTo("English"))
                .body("Course[0]",equalTo("Telugu"))
                .log().all();

    }
}
