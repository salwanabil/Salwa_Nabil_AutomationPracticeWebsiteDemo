package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteSampleRequest {
    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/pet/9222968140497499000")
                .then()
                .extract().response();

        //404 error code as supplied pet id may be not found
        Assert.assertEquals(404, response.statusCode());
    }
}
