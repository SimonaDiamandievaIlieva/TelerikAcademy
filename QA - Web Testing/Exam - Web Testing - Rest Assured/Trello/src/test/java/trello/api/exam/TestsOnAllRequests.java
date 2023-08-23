package trello.api.exam;

import com.telerikacademy.api.tests.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.FULL_NAME;
import static com.telerikacademy.api.tests.Endpoints.API_BOARDS;
import static com.telerikacademy.api.tests.Endpoints.API_CARDS;
import static com.telerikacademy.api.tests.JSONRequests.requestBody;
import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class TestsOnAllRequests {

    public static String boardId;
    public static String listId;
    public static String cardId;

    @Test(priority = 1)
    public void authenticateTest() {

        baseURI = String.format("%s/1/members/me", BASE_URL);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .param("key", USER_KEY)
                .param("token", USER_API)
                .log().all()
                .when().get();


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");


        String fullName = response.jsonPath().getString("fullName");
        assertEquals(fullName, FULL_NAME, "Incorrect name.");

    }

    @Test(priority = 2)
    public void createNewBoard() {


        baseURI = String.format("%s%s", BASE_URL, API_BOARDS);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("name", BOARD_NAME)
                .queryParam("key", USER_KEY)
                .queryParam("token", USER_API)
                .log().all()
                .when().post();


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");

        boardId = response.jsonPath().getString("id");

        String name = response.jsonPath().getString("name");
        assertEquals(name, BOARD_NAME, "Incorrect name.");

    }

    @Test(priority = 3)
    public void createListOnBoard() {

        baseURI = String.format("%s%s%s/lists", BASE_URL, API_BOARDS, boardId);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("name", BOARD_NAME)
                .queryParam("key", USER_KEY)
                .queryParam("token", USER_API)
                .log().all()
                .when().post();


        int statusCode2 = response.getStatusCode();
        assertEquals(statusCode2, SC_OK, "Incorrect status code. Expected 200.");

        String name = response.jsonPath().getString("name");
        assertEquals(name, BOARD_NAME, "Incorrect name.");

        listId = response.jsonPath().getString("id");
    }

    @Test(priority = 4)
    public void createNewCard() {


        baseURI = String.format("%s%s", BASE_URL, API_CARDS);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("idList", listId)
                .queryParam("key", USER_KEY)
                .queryParam("token", USER_API)
                .log().all()
                .when().post();


        int statusCode2 = response.getStatusCode();
        assertEquals(statusCode2, SC_OK, "Incorrect status code. Expected 200.");

        cardId = response.jsonPath().getString("id");

    }

    @Test(priority = 5)
    public void updateACardName() {


        baseURI = String.format("%s%s%s", BASE_URL, API_CARDS, cardId);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("key", USER_KEY)
                .queryParam("token", USER_API)
                .queryParam("token", "newName")
                .body(requestBody)
                .log().all()
                .when().put();


        int statusCode2 = response.getStatusCode();
        assertEquals(statusCode2, SC_OK, "Incorrect status code. Expected 200.");

    }

    @Test(priority = 6)
    public void updateACardColor() {


        baseURI = String.format("%s%s%s", BASE_URL, API_CARDS, cardId);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("key", USER_KEY)
                .queryParam("token", USER_API)
                .body(requestBody)
                .log().all()
                .when().put();


        int statusCode2 = response.getStatusCode();
        assertEquals(statusCode2, SC_OK, "Incorrect status code. Expected 200.");

        String color = response.jsonPath().getString("cover.color");
        assertEquals(color, COLOR, "Incorrect color.");
    }

    @Test(priority = 7)
    public void deleteBoard() {


        baseURI = String.format("%s%s%s", BASE_URL, API_BOARDS, boardId);
        System.out.println(baseURI);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("key", USER_KEY)
                .queryParam("token", USER_API)
                .log().all()
                .when().delete();


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");

    }
}
