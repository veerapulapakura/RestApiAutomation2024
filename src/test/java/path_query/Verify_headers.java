package path_query;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Verify_headers {

    @Test(priority =2)
    public void HeaderValidation(){

        //Response res = RestAssured.get("https://www.google.com/");

        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Encoding","gzip")
                .and()
                .header("Server","gws")
                .and()
                .header("Content-Type","text/html; charset=ISO-8859-1")//Content-Type
                .and()
                .statusCode(200)
                .log().all();
    }

    @Test(priority =2)
    public void GetHeaderInformation() {
        Response res = RestAssured.get("https://www.google.com/");
        String headervalue = res.getHeader("Content-Encoding");
        System.out.println("Header value  is    "+ headervalue);
        //Getting all the headers
        Headers headers = res.getHeaders();
        for(Header Head : headers){
            System.out.println(" Printing "+Head.getName()+ "     -------    "+Head.getValue());

        }

    }
    }
