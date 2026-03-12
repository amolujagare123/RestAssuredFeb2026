package DeckOfCards;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ShuffleCards {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://deckofcardsapi.com";

        given().log().all()
                .queryParam("deck_count","1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat()
                .statusCode(200)
                .body("remaining",equalTo(52))
                .body("shuffled",equalTo(true))
                .time(lessThan(2000L));
    }
}
