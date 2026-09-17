package com.restassured.demo;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class BDDGetRequest {

    public static void main(String[] args) {

        Response response = given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees")
                .then()
                .extract()
                .response();

        System.out.println("Status Code : " + response.getStatusCode());

        System.out.println("Complete Response : ");
        System.out.println(response.asPrettyString());

        System.out.println("Response Body : ");
        System.out.println(response.getBody().asPrettyString());

        System.out.println("Status Line : " + response.getStatusLine());

        System.out.println("Content Type : " + response.getContentType());

        System.out.println("Response Time : " + response.getTime() + " ms");
    }
}