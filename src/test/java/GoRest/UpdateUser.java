package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .contentType("application/json")
              .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body("{\n" +
                        "    \"name\": \"Aarav Mehta\",\n" +
                        "    \"email\": \"aarav.mehta@gmail.com\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().put("/public/v2/users/8379488")
                .then().statusCode(200);
    }
}
