package restAssuredTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import java.io.File;
import java.util.Base64;
import static restAssuredTest.Credentials.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestAssuredJiraTests {
    private static String storyKey;
    private static String bugKey;
    private static final String authString = USERNAME + ":" + API_TOKEN_OR_PASSWORD;
    private static final String authHeader = "Basic " + Base64.getEncoder().encodeToString(authString.getBytes());
    @Test
    @Order(1)
    public void storyIsCreated_when_authenticateCorrectly() {
        RestAssured.baseURI = BASE_URL;

        Response response = RestAssured.given()
                .header("Authorization", authHeader)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "        \"project\": {\n" +
                        "            \"key\": \"" + PROJECT_KEY + "\"\n" +
                        "        },\n" +
                        "        \"issuetype\": {\n" +
                        "            \"name\": \"Story\"\n" +
                        "        },\n" +
                        "        \"summary\": \"Try to receive information about the site\",\n" +
                        "        \"description\": \"*Description:*\\n As a user I want to see information about the company from their website." +
                        "\\n *Preconditions:*\\n Navigate to https://www.phptravels.net/ru \\n *Test Steps:*" +
                        "\\n 1. Scroll to the bottom of the homepage. \\n 2. Click on “About Us”. " +
                        "\\n 3. The page is redirected to https://www.phptravels.net/About-Us \\n  *Expected result:*" +
                        "\\n A page with information about the company is displayed.\",\n" +
                        "        \"priority\": {\n" +
                        "            \"name\": \"Medium\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")
                .when().post("/issue");

        Assertions.assertEquals(201, response.statusCode());

        String createStoryId = response.jsonPath().getString("id");
        String createStoryKey = response.jsonPath().getString("key");
        storyKey = response.jsonPath().getString("key");

        Assertions.assertNotNull(createStoryId, "Created story id must not be null");
        Assertions.assertFalse(createStoryId.isEmpty(), "Created story id must not be empty string");
        Assertions.assertNotNull(createStoryKey, "Created story key must not be null");
        Assertions.assertFalse(createStoryKey.isEmpty(), "Created story key must not be empty string");

        String expectedContentType = "application/json;charset=UTF-8";
        Assertions.assertEquals(expectedContentType, response.getContentType());
    }

    @Test
    @Order(2)
    public void bugIsCreated_when_authenticateCorrectly() {
        RestAssured.baseURI = BASE_URL;

        String jsonBody = "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "           \"key\": \"" + PROJECT_KEY + "\"\n" +
                "        },\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        },\n" +
                "        \"summary\": \"About Us information page in Russian version is empty\",\n" +
                "        \"description\": \"*Description:*\\n As a user I want to see information about the company from their website." +
                "\\n *Preconditions:*\\n Browser: Mozilla Firefox 2019 08 10 10 11 28 \\n *Steps to reproduce:*" +
                "\\n 1. Navigate to https://www.phptravels.net/ru \\n 2. Scroll to the bottom of the homepage." +
                "\\n 3. Click on “About Us” \\n 4. The page is redirected to https://www.phptravels.net/About-Us" +
                " \\n  *Expected result:*" +
                "\\n A page with information about the company is displayed.\\n " +
                "*Actual result:* There is no information about the company on their website. The page is empty\"\n" +
                "    }\n" +
                "}";

        Response response = RestAssured.given()
                .header("Authorization", authHeader)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when().post("/issue");

        Assertions.assertEquals(201, response.getStatusCode());

        String createdBugId = response.jsonPath().getString("id");
        String createdBugKey = response.jsonPath().getString("key");
        bugKey = response.jsonPath().getString("key");

        Assertions.assertNotNull(createdBugId, "Created bug id must not be null");
        Assertions.assertNotNull(createdBugKey, "Created bug key must not be null");
        Assertions.assertFalse(createdBugId.isEmpty(), "Created bug id must not be empty string");
        Assertions.assertFalse(createdBugKey.isEmpty(), "Created bug key must not be empty string");

        String expectedContentType = "application/json;charset=UTF-8";
        Assertions.assertEquals(expectedContentType, response.getContentType());
    }

    @Test
    @Order(3)
    public void linkBugToStory_when_authenticateCorrectly() {
        RestAssured.baseURI = BASE_URL;

        String requestBody = "{\n" +
                "    \"type\": {\n" +
                "        \"id\": \"10000\"\n" +
                "    },\n" +
                "    \"inwardIssue\": {\n" +
                "        \"key\": \"" + bugKey + "\"\n" +
                "    },\n" +
                "    \"outwardIssue\": {\n" +
                "        \"key\": \"" + storyKey + "\"\n" +
                "    }\n" +
                "}";

       Response response =  RestAssured.given()
                .header("Authorization", authHeader)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/issueLink");

        Assertions.assertEquals(201, response.getStatusCode());
    }

    @Test
    @Order(4)

    public void attachedFile_when_BugIsCreated () {
        RestAssured.baseURI = BASE_URL;
        String filePath = "src/main/resources/image.jpg";
        File fileToAttach = new File(filePath);

        Response response =  RestAssured.given()
                .header("Authorization", authHeader)
                .header("X-Atlassian-Token", "no-check")
                .header("Content-Type", "multipart/form-data")
                .multiPart(fileToAttach)
                .when()
                .post(String.format("issue/%s/attachments", bugKey));

        Assertions.assertEquals(200, response.getStatusCode());
        String expectedContentType = "application/json;charset=UTF-8";
        Assertions.assertEquals(expectedContentType, response.getContentType());
    }
}

