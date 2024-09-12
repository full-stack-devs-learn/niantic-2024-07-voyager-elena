package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest {

    private Dagger dagger;
    // name taken from this website https://www.fantasynamegenerators.com/dagger-names.php
    private final String daggerName = "Fleshshaper";
    private final int damage = 5;
    private int daggerCount = 10;


    @BeforeEach
    public void setup() {
         dagger = new Dagger(daggerName, damage, daggerCount);
    }

    @Test
    public void parameterizedConstructor_ShouldCreateSwordCorrectly_withGivenNameAndDamageAndDaggerCount() {
        // arrange
        String expectedName = daggerName;
        int expectedDamage = damage;
        int expectedDaggerCount = daggerCount;
        int expectedPercentCharged = 0;

        // act

        // assert
        assertNotNull(dagger, "Dagger object should be created");
        assertEquals(expectedName, dagger.getName(), "The dagger name should be" + expectedName);
        assertEquals(expectedDamage, dagger.getDamage(), "The dagger damage should be equal to " + expectedDamage);
        assertEquals(expectedDaggerCount, dagger.getDaggerCount(), "The dagger damage should be equal to " + expectedDamage);
        assertEquals(expectedPercentCharged, dagger.getPercentCharged(), "The dagger percentCharged should be equal to " + expectedPercentCharged);
    }


    @Test
    void attack_shouldReturn0_whenDiggerCountIs0() {
        // arrange
        int count = dagger.getDaggerCount();
        for (int i = 0; i < count; i++) {

        }
    }

    @Test
    void powerAttack() {
    }

    @Test
    void getRange() {
    }

    @Test
    void addDagger() {
    }
}