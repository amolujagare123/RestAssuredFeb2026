package DeckOfCards;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DrawCard {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        given().log().all()
                .queryParam("count","2")
                .when().get("/api/deck/c7u9cg4pztms/draw/")
                .then().log().all().assertThat().statusCode(200);
    }
}
