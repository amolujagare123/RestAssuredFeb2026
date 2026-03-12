package ChatServer;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class CreateUserChtServerSpc {

    public static void main(String[] args) {

     /*   RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin/";

        given().log().all()
                .contentType("application/json")
                .auth().preemptive().basic("admin","demo")
                .body("{\n" +
                        "  \"username\": \"rohit.patil\",\n" +
                        "  \"password\": \"TestPass456\",\n" +
                        "  \"email\": \"rohit.patil@example.com\",\n" +
                        "  \"name\": \"Rohit\",\n" +
                        "  \"surname\": \"Patil\",\n" +
                        "  \"chat_nickname\": \"RohitDev\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);*/

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("demo");


        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://demo.livehelperchat.com/site_admin/")
                .setContentType("application/json")
                .setAuth(auth).build();

        RequestSpecification request = given().log().all().spec(requestSpecification)
                .body("{\n" +
                        "  \"username\": \"rohit.patil\",\n" +
                        "  \"password\": \"TestPass456\",\n" +
                        "  \"email\": \"rohit.patil@example.com\",\n" +
                        "  \"name\": \"Rohit\",\n" +
                        "  \"surname\": \"Patil\",\n" +
                        "  \"chat_nickname\": \"RohitDev\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}");


        Response response = request.when().post("/restapi/user");

        ResponseSpecification reponseSpecification = new ResponseSpecBuilder().expectStatusCode(201)
                .build();

        String respStr = response.then().log().all().spec(reponseSpecification).extract().asString();

        System.out.println(respStr);

    }
}
