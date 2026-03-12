import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class NeJsonDemoCreate {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().log().all()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "        \"name\": \"Test User\",\n" +
                        "        \"username\": \"testuser\",\n" +
                        "        \"email\": \"test@user.com\",\n" +
                        "        \"address\": {\n" +
                        "          \"street\": \"Has No Name\",\n" +
                        "          \"suite\": \"Apt. 123\",\n" +
                        "          \"city\": \"Electri\",\n" +
                        "          \"zipcode\": \"54321-6789\"\n" +
                        "        }\n" +
                        "      }")
                .when().post("/users")
                .then().log().all().assertThat().statusCode(201);


    }
}
