package Jobportal;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateJobSpecBuilder {

    public static void main(String[] args) throws IOException {

      //  RestAssured.baseURI = "http://localhost:9897/";

        Path path = Paths.get("json/payload.json");

        byte[] file = Files.readAllBytes(path);

        String payload = new String(file);


      /*  given().log().all()
                .body(payload)
                .accept("application/json")
                .contentType("application/json")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
   */

        RequestSpecification requestSpecificationObject
                = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .setAccept("application/json")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpecificationObject)
                .body(payload);


        Response response = request.when().post("/normal/webapi/add");

        ResponseSpecification responseSpecificationObj
                = new ResponseSpecBuilder().expectStatusCode(200).build();


        String respStr = response.then().log().all().extract().response().asString();

        System.out.println(respStr);
    }
}
