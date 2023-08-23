package trello.api.exam;

import com.telerikacademy.api.tests.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.API_BOARDS;
import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateNewBoard {

    @Test
    public void createNewBoard() {


        baseURI = String.format("%s%s", BASE_URL, API_BOARDS);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("name" , BOARD_NAME)
                .queryParam("key" , USER_KEY)
                .queryParam("token" , USER_API)
                .log().all()
                .when().post();


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");

        String name = response.jsonPath().getString("name");
        assertEquals(name, BOARD_NAME, "Incorrect name.");

    }
}
