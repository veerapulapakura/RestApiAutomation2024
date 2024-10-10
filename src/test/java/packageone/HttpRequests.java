package packageone;

/*import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;*/

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HttpRequests {

    int id;
    @Test(priority =1)
    public void getUsers(){

        given().when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();

    }


    //@Test(priority =2)
    public void postData(){

        HashMap data = new HashMap();
        data.put("name", "Veera");
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

    @Test(priority =3)
    public void postData2(){

        HashMap data = new HashMap();
        data.put("name", "Ratna");
        data.put("Job", "Computers");

        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
        System.out.println("Id gathered is \n\n"+id);
    }


    @Test(priority =4, dependsOnMethods = {"postData2"})
    public void UpdatingData(){

        HashMap data = new HashMap();
        data.put("name", "RatnaKumar1");
        data.put("Job", "ComputersSection");

                 given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/"+id)
                         .then()
                         .statusCode(200)
                         .log().all();

    }

    @Test(priority =5, dependsOnMethods = {"UpdatingData"})
    public void DeleteData(){

        given()
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();

    }


}
