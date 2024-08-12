package path_query;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Cookies_Headers {

    @Test(priority =2)
    public void GetCookies(){

        given()
                //.pathParam("mypath", "users")
                //.queryParam("id",5)
                // .queryParam("page",2)
                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .cookie("AEC", "Veera")
                .log().all();
    }

  /*  //@Test(priority =2)
    public void GetCookiesInfo(){

        ValidatableResponse res = given()
                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .log().all();
        System.out.println(" - - - - -Printing response     - - - "   +res.toString());
    }
*/

    @Test(priority =2)
    public void GetOneCookie(){

//        Response res = (Response) given()
//                .when()
//                .get("https://www.google.com/")
//                .then()
//                .statusCode(200)
//                .log().all();

        Response res = RestAssured.get("https://www.google.com/");
        String cookie_value = res.getCookie("AEC");
        System.out.println("Value of the Cookie is\n"+cookie_value);

    }



    @Test(priority =2)
    public void Cookies_KeyValue(){
        Response res = RestAssured.get("https://www.google.com/");
        Map<String,String> allcookies = res.getCookies();
        System.out.println("Printing all the cookies\n"+allcookies.keySet());
        System.out.println("Iterating  all the cookies\n");

        for(String K: allcookies.keySet()) {
            String cookie_value = res.getCookie(K);
            System.out.println(K + "    " + cookie_value);
        }

    }
}
