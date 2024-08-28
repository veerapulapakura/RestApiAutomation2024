package authentication;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basic_Auth {

@Test(priority =2)
public void Authentication(){

    given()
            .auth().basic("postman","password")
            .when()
            .get("https://postman-echo.com/basic-auth")
            .then()
            .statusCode(200)
            .body("authenticated",equalTo(true))
            .log().all();
            //Assert.assertEquals(res.getStatusCode(), 200);
}

    @Test(priority =2)
    public void DigestAuthentication(){

        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
        //Assert.assertEquals(res.getStatusCode(), 200);
    }


    @Test(priority =3)
    public void PreemptiveAuthentication(){

        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
        //Assert.assertEquals(res.getStatusCode(), 200);
    }


    @Test(priority =3)
    public void BearerTokenAuthentication()
    {
        //String token="";
        given()
                .headers("Authorization", "Bearer "+token)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                //.body("authenticated",equalTo(true))
                .log().all();
    }
}
