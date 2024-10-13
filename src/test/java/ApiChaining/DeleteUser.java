package ApiChaining;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Test
    public void deleteUser(ITestContext context) {


        String bearerToken = "8071f554902b8c4e20845f9a54b7c8e5257f76c951b1cafcc25333a529b019bf";
        String id = (String) context.getAttribute("valueToPass");

        Response response = (Response) given()
                .headers("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .pathParam("id", id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}");

        int status = response.statusCode();
        Assert.assertEquals(status,404);
    }

}
