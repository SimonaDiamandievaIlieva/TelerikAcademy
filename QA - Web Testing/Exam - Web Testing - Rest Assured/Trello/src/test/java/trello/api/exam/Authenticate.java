package trello.api.exam;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.USER_API;
import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class Authenticate {

    @Test
    public void authenticateTest() {

        baseURI = String.format("%s/1/members/me", BASE_URL);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .param("key" , USER_KEY)
                .param("token" , USER_API)
                .log().all()
                .when().get();


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");


        String fullName = response.jsonPath().getString("fullName");
        assertEquals(fullName, FULL_NAME, "Incorrect name.");

    }
}
