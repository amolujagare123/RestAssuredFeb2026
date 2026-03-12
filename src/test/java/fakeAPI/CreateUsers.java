package fakeAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com";

        given().log().all()
            //    .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body(" {\n" +
                        "    \"name\": \"Amaya Toy\",\n" +
                        "    \"company\": \"Ritchie, Bruen and Mayert\",\n" +
                        "    \"username\": \"Cordelia.Denesik\",\n" +
                        "    \"email\": \"Antoinette.Hilpert27@gmail.com\",\n" +
                        "    \"address\": \"436 Wunsch Glens\",\n" +
                        "    \"zip\": \"20932\",\n" +
                        "    \"state\": \"Indiana\",\n" +
                        "    \"country\": \"Israel\",\n" +
                        "    \"phone\": \"391.285.7864 x137\",\n" +
                        "    \"photo\": \"https://json-server.dev/ai-profiles/48.png\"\n" +
                        "  }")
                .when().post("/users")

                .then().log().all().assertThat()
                .statusCode(200);
    }


}
