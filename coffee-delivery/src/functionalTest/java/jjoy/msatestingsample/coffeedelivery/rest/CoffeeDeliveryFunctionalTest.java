package jjoy.msatestingsample.coffeedelivery.rest;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoffeeDeliveryFunctionalTest {

    @ClassRule
    public static WireMockClassRule wireMockClassRule = new WireMockClassRule(5959);

    @LocalServerPort
    private int port;

    @Before
    public void stubs() throws Exception {
        stubFor(get(urlEqualTo("/bread/bagel"))
                .willReturn(okJson("{\"name\" : \"bagel\"}")));
    }

    @Before
    public void restAssuredSetup() throws Exception {

        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void coffeeMenuTest() throws Exception {
        when().get("/coffees").then().body("$", hasSize(3));
    }

    @Test
    public void morningComboTest() throws Exception{
        when().get("/morningCombo")
                .then().statusCode(HttpStatus.SC_OK)
                .body("coffee.name", is("Americano"));
    }
}

