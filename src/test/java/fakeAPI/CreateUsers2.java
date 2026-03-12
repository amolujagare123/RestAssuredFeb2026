package fakeAPI;

import io.restassured.RestAssured;
import pojo.FakeAPI.CreateUserFakeAPIPOJO;

import static io.restassured.RestAssured.given;

public class CreateUsers2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com";


        CreateUserFakeAPIPOJO ob = new CreateUserFakeAPIPOJO();
        ob.setName("Amaya Toy");
        ob.setCompany("Ritchie, Bruen and Mayert");
        ob.setUsername("Cordelia.Denesik");
        ob.setEmail("Antoinette.Hilpert27@gmail.com");
        ob.setAddress("436 Wunsch Glens");
        ob.setZip("20932");
        ob.setState("Indiana");
        ob.setCountry("Israel");
        ob.setPhone("391.285.7864 x137");
        ob.setPhoto("https://json-server.dev/ai-profiles/48.png");

        given().log().all()
            //    .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body(ob)
                .when().post("/users")

                .then().log().all().assertThat()
                .statusCode(200);
    }


}
