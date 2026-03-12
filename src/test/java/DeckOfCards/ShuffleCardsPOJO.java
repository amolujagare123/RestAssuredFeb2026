package DeckOfCards;

import io.restassured.RestAssured;
import pojo.DeckOfCards.DeckResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ShuffleCardsPOJO {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://deckofcardsapi.com";

        DeckResponse respObj = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat()
                .statusCode(200)
                .extract().as(DeckResponse.class);

        String id = respObj.getDeck_id();
        boolean shuffled = respObj.isShuffled();
        int remaining = respObj.getRemaining();
        boolean success = respObj.isSuccess();

        System.out.println("id = " + id);
        System.out.println("shuffled = " + shuffled);
        System.out.println("remaining = " + remaining);
        System.out.println("success = " + success);


    }
}
