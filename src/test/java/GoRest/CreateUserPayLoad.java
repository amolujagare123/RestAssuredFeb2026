package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.GoRestCrateUserPayLoad.goRestPayLoad;

public class CreateUserPayLoad {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://gorest.co.in/";

       /* given().log().all()
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
              //  .header("Content-Type","application/json")
                .contentType("application/json")
                .body(goRestPayLoad())
                .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);*/


        given().log().all()
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                //  .header("Content-Type","application/json")
                .contentType("application/json")
                .body(goRestPayLoad("Shubham","shubham123@gmail.com","male","active"))
                .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
