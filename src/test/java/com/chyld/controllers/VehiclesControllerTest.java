package com.chyld.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Sql(value = {"/clean-Vehicles-database.sql"})
public class VehiclesControllerTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.port = 8001;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    // GET /api/vehicles
    public void shouldGetAllTheVehicles() throws Exception {
        get("/api/vehicles")
                .then()
                .statusCode(200)
                .body("numberOfElements", is(3));
    }

    @Test
    // GET /api/vehicles/:id
    public void shouldGetASingleVehicle() throws Exception {
        get("/api/vehicles/1")
                .then()
                .statusCode(200)
                .body("make", is("Toyota"));
    }

    @Test
    // POST /api/vehicles
    public void shouldCreateAVehcile() throws Exception {
        Map<String, Object> json = new HashMap<>();
        json.put("make", "Chevy");
        json.put("model", "abc");
        json.put("year", "2002");

        given().
                contentType(ContentType.JSON).
                body(json).
                when().
                post("/api/vehicles")
                .then()
                .statusCode(200)
                .body("id", is(8));
    }

    @Test
    // DELETE /api/vehicles/:id
    public void shouldDeleteAVehicle() throws Exception {
        when().
                delete("/api/vehicles/1")
                .then()
                .statusCode(200);
    }

}