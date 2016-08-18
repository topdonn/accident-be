package com.chyld.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


public class PersonTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateAnInstanceOfPerson() throws Exception {
        Person p = new Person("John Doe", 32, "M", 175);
        assertThat(p, instanceOf(Person.class));
        assertTrue(p.getName().equalsIgnoreCase("John Doe"));
        assertTrue(p.getAge() ==  32);
        assertTrue(p.getMonthly() == 175);
    }
}