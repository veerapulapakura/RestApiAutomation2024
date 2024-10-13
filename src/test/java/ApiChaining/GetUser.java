package ApiChaining;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void tes_getNewUser(ITestContext context){
        String bearerToken = "8071f554902b8c4e20845f9a54b7c8e5257f76c951b1cafcc25333a529b019bf";
        String id = (String) context.getAttribute("valueToPass");

        Response response = (Response) given()
                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)
                .when()
                .get("https://gorest.co.in/public/v2/users{id}");
                //.then()
               // .statusCode(404);
        System.out.println(response);
    }
}
