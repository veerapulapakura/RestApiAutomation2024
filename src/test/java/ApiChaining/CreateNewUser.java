package ApiChaining;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateNewUser {
    @Test
    void tes_createUser(ITestContext context){
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name", faker.firstName());
        data.put("email","veera.ratna@gmail.com");
        data.put("Gender","Male");
        data.put("status","Inactive");
        String bearerToken = "8071f554902b8c4e20845f9a54b7c8e5257f76c951b1cafcc25333a529b019bf";

        Response response = given()
                .headers("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .when()
                .post("https://gorest.co.in/public/v2/users");
                //.jsonPath().getInt("id"):

        String strvalue = response.toString();
        String[] splitvalue =  strvalue.split("@");
        System.out.println("Printing response in string  " + strvalue);
        System.out.println("Printing the vlaue after split with @ " + splitvalue);
        System.out.println("Printing the value before @ " + splitvalue[0]);
        System.out.println("Printing the value after @   " + splitvalue[1]);

        String responsecode = String.valueOf(response.statusCode());
        System.out.println("Printing response response code value   " + responsecode);
        context.setAttribute("valueToPass", splitvalue[1]);
    }
}
