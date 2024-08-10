package packageone;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostPOJO_Data {

    @Test(priority =2)
    public void postData() {

        POJO_Data data = new POJO_Data();

        String[] courses={"Telugu", "English"};
        data.setName("Ratna");
        data.setJob("Veera");
        data.setCourses(courses);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name",equalTo("Ratna"))
                .body("courses[1]",equalTo("English"))
                .body("courses[0]",equalTo("Telugu"))
                .log().all();

    }

}
