package com.niantic.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputerTest {
    private Computer computer;

    @BeforeEach
    public void setup() {
        computer = new Computer();
    }

    @Test
    @Order(1)
    public void defaultConstructor_createsFirstComputer_withCorrectName() {
        // arrange
        String expectedComputerName = "Computer 1";
        // act

        // assert
        assertNotNull(computer, "Computer object should be created");
        String actualComputerName = computer.getName();
        assertEquals(expectedComputerName, actualComputerName, "Computer name should be \"" + expectedComputerName + "\"");
    }

    @Test
    @Order(2)
    public void defaultConstructor_createsSecondComputer_withCorrectName() {
        // arrange
        String expectedComputerName = "Computer 2";
        // act
        String actualComputerName = computer.getName();

        // assert
        assertEquals(expectedComputerName, actualComputerName, "Computer name should be \"" + expectedComputerName + "\"");
    }

}