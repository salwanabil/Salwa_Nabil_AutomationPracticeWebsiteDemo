package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class GetSampleRequest {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void getRequestWithQueryParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.getStatusCode());
        //Assert.assertEquals("fish",response.jsonPath().getString("name[8]"));
    }
}
