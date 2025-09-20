package com.ecommerce.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void testApiEndpoint(){

        String requestUrl = "https://jsonplaceholder.typicode.com/posts/1";

        given().
                when().
                get(requestUrl).
                then().
                // Assert that the status code is 200 (OK)
                        assertThat().statusCode(200).
                // Assert that the response body contains a specific value
                        and().body("userId", equalTo(1));
    }
}
