package com.restAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestEndpointTest extends Specification{

    @BeforeEach
    public void baseSetup(){
            setup();
    }

    @Test
    public void getUserByIdTest() {
        given()
                .spec(reqSpec)
                .when()
                .get("/api/users/2")
                .then()
                .assertThat()
                .body("data.first_name", equalTo("Janet"))
                .statusCode(HttpStatus.SC_OK)
                .time(Matchers.lessThan(3000l));
    }

    @Test
    public void getUserListTest() {
        given()
                .spec(reqSpec)
                .when()
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .body("page", equalTo(2), "data.id", hasItems(7, 8, 9, 10, 11, 12), "data.first_name", hasItems("Michael"))
                .statusCode(HttpStatus.SC_OK)
                .time(Matchers.lessThan(2000l));
    }

    @Test
    public void getUnExistingResource() {
        given()
                .spec(reqSpec)
                .when()
                .get("/api/unknown/23")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .time(Matchers.lessThan(1000l));
    }

    @Test
    public void postUser() {
        given()
                .spec(reqSpec)
                .header("Content-type", ContentType.APPLICATION_JSON.toString())
                .queryParam("name", "Olga", "job", "Tester")
                .post("/api/users")
                .then()
                .body("id", notNullValue(), "createdAt", notNullValue())
                .statusCode(HttpStatus.SC_CREATED)
                .time(Matchers.lessThan(1000l));
    }

    @Test
    public void postRegisterBadRequest() {
        given()
                .spec(reqSpec)
                .header("Content-type", ContentType.APPLICATION_JSON.toString())
                .queryParam("email", "olga@gmail.com")
                .post("/api/register")
                .then()
                .body("error", equalTo("Missing email or username"))
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .time(Matchers.lessThan(1000l));
    }

    @Test
    public void putUpdateUserById() {
        given()
                .spec(reqSpec)
                .header("Content-type", ContentType.APPLICATION_JSON.toString())
                .queryParam("name", "Olga", "job", "Tester")
                .put("/api/users/2")
                .then()
                .body("updatedAt", notNullValue())
                .statusCode(HttpStatus.SC_OK)
                .time(Matchers.lessThan(1000l));
    }

    @Test
    public void patchUpdateUserById() {
        given()
                .spec(reqSpec)
                .header("Content-type", ContentType.APPLICATION_JSON.toString())
                .queryParam("name", "Olga2", "job", "Tester2")
                .put("/api/users/3")
                .then()
                .body("updatedAt", notNullValue())
                .statusCode(HttpStatus.SC_OK)
                .time(Matchers.lessThan(1000l));
    }

    @Test
    public void deleteUserById() {
        given()
                .spec(reqSpec)
                .header("Content-type", ContentType.APPLICATION_JSON.toString())
                .delete("/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .time(Matchers.lessThan(1000l));
    }
}
