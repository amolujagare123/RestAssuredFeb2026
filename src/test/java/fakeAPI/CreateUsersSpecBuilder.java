package fakeAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.FakeAPI.CreateUserFakeAPIPOJO;

import static io.restassured.RestAssured.given;

public class CreateUsersSpecBuilder {

    public static void main(String[] args) {

       // RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com";


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

     /*   given().log().all()
            //    .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body(ob)
                .when().post("/users")

                .then().log().all().assertThat()
                .statusCode(200);*/


        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://fake-json-api.mock.beeceptor.com")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpecification).body(ob);

        Response response = request.when().post("/users");

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).build();

        String respStr = response.then().log().all().spec(responseSpecification).extract().asString();

        System.out.println(respStr);
    }


}
