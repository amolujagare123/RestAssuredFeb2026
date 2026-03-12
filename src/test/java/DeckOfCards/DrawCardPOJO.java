package DeckOfCards;

import io.restassured.RestAssured;
import pojo.DeckOfCards.Cards;
import pojo.DeckOfCards.Images;
import pojo.DeckOfCards.ShuffleCardsResponse;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class DrawCardPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        ShuffleCardsResponse respObj = given().log().all()
                .queryParam("count", "2")
                .when().get("/api/deck/c7u9cg4pztms/draw/")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(ShuffleCardsResponse.class);

        // give the png value of  image of fist card

        ArrayList<Cards> cards = respObj.getCards();
        
        Cards card = cards.get(0);
        Images images = card.getImages();
        String pngValue = images.getPng();

        System.out.println("pngValue="+pngValue);

        String png = respObj.getCards().get(0).getImages().getPng();
    }
}
