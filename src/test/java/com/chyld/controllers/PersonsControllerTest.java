package com.chyld.controllers;

import com.chyld.enums.Gender;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/clean-database.sql"})
public class PersonsControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    // GET /api/Persons
    public void shouldGetAllThePersons() throws Exception {
        get("/api/persons")
            .then()
            .statusCode(200)
            .body("numberOfElements", is(5));
    }

    @Test
    // GET /api/Persons/:id
    public void shouldGetASinglePerson() throws Exception {
        get("/api/persons/1")
            .then()
            .statusCode(200)
            .body("name", is("mr. man"));
    }

    @Test
    // POST /api/Persons
    public void shouldCreateAPerson() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("name", "miss USA");
        json.put("age", "30");
        json.put("gender", "F");
        json.put("monthlyPayment", "150");

        given().
            contentType(ContentType.JSON).
            body(json).
        when().
            post("/api/persons")
        .then()
            .statusCode(200)
            .body("id", is(6));
    }

    @Test
    // DELETE /api/Persons/:id
    public void shouldDeleteAPerson() throws Exception {
        when().
            delete("/api/persons/1")
        .then()
            .statusCode(200);
    }

}
