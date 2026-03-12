package Jobportal;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateJob {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "http://localhost:9897/";

        Path path = Paths.get("json/payload.json");

        byte[] file = Files.readAllBytes(path);

        String payload = new String(file);


        given().log().all()
                .body(payload)
                .accept("application/json")
                .contentType("application/json")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
