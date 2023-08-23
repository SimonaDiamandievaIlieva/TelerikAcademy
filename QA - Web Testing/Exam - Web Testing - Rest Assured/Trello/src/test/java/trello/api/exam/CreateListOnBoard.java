package trello.api.exam;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.USER_API;
import static com.telerikacademy.api.tests.Endpoints.API_BOARDS;
import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class CreateListOnBoard {

    @Test
    public void createListOnBoard() {

        baseURI = String.format("%s%s", BASE_URL, API_BOARDS);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("name" , BOARD_NAME)
                .queryParam("key" , USER_KEY)
                .queryParam("token" , USER_API)
                .log().all()
                .when().post();


       String boardId = response.getBody().jsonPath().get("id");


        baseURI = String.format("%s%s%s/lists", BASE_URL, API_BOARDS, boardId);
        System.out.println(baseURI);

        Response response2 = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("name" , BOARD_NAME)
                .queryParam("key" , USER_KEY)
                .queryParam("token" , USER_API)
                .log().all()
                .when().post();


        int statusCode2 = response2.getStatusCode();
        assertEquals(statusCode2, SC_OK, "Incorrect status code. Expected 200.");

        String name = response.jsonPath().getString("name");
        assertEquals(name, BOARD_NAME, "Incorrect name.");
    }
}
