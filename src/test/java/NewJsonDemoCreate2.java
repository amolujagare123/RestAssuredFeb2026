import io.restassured.RestAssured;
import pojo.Address;
import pojo.NewJsonCreatePOJO;

import static io.restassured.RestAssured.given;

public class NewJsonDemoCreate2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        NewJsonCreatePOJO ob = new NewJsonCreatePOJO();
        ob.setName("rajveer");
        ob.setEmail("rajveer@gmail.com");
        ob.setUsername("rajveer");

        Address address = new Address();
        address.setStreet("MG road");
        address.setSuite("near xyz");
        address.setCity("Pune");
        address.setZipcode("343434");

        ob.setAddress(address);


        given().log().all()
                .accept("application/json")
                .contentType("application/json")
                .body(ob)
                .when().post("/users")
                .then().log().all().assertThat().statusCode(201);


    }
}
