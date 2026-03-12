package fakeAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com";

        given().log().all()
            //    .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .when().get("/users")
                .then().log().all().assertThat()
                .statusCode(200);
    }


}
