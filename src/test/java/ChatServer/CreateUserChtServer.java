package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUserChtServer {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin/";

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
                .then().log().all().assertThat().statusCode(200);
    }
}
