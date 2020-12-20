package com.restAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public RequestSpecification reqSpec;

        public void setup() {
            RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
            reqBuilder.setBaseUri("https://reqres.in/");
            reqSpec = reqBuilder.build();
    }
}
