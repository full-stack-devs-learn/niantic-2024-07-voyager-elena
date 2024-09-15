package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest {

    private Dagger dagger;
    // name taken from this website https://www.fantasynamegenerators.com/dagger-names.php
    private final String daggerName = "Fleshshaper";
    private final int damage = 5;


    @BeforeEach
    public void setup() {
        dagger = new Dagger(daggerName, damage);
    }

    @Test
    public void parameterizedConstructor_shouldCreateDaggerCorrectly_withGivenNameAndDamageAndDaggerCount() {
        // arrange
        String expectedName = daggerName;
        int expectedDamage = damage;
        int expectedDaggerCount = 1;
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
    void attack_shouldIncrease_percentChargedBy20() {
        // arrange
        int expectedPercentCharged = 20;

        // act
        dagger.attack();
        int actualPercentCharged = dagger.getPercentCharged();

        // assert
        assertEquals(expectedPercentCharged, actualPercentCharged, "Regular attack should increase percent charged by 20%");
    }

    @Test
    void attack_shouldNotIncrease_percentCharged_when100() {
        // arrange
        int expectedPercentCharged = 100;
        for (int i = 0; i < 5; i++) {
            dagger.attack();
        }

        // act
        dagger.attack();
        int actualPercentCharged = dagger.getPercentCharged();

        // assert
        assertEquals(expectedPercentCharged, actualPercentCharged, "The Percent charged cannot exceed 100");
    }

    @Test
    void attack_shouldReturn_defaultDamage() {
        // arrange
        int expectedAttackResult = damage;

        // act
        int actualAttackResult = dagger.attack();

        // assert
        assertEquals(expectedAttackResult, actualAttackResult, "Attack should return default damage");
    }

    @Test
    void attack_shouldReturn0_whenDaggerCountIs0() {
        // arrange
        // set powerCharged to 100  for powerAttack
        for (int i = 0; i < 5; i++) {
            dagger.attack();
        }
        // call powerAttack to decrease number of daggers to zero
        dagger.powerAttack();
        int expectedAttackResult = 0;

        // act
        int actualAttackResult = dagger.attack();

        // assert
        assertEquals(expectedAttackResult, actualAttackResult, "Attack should be equal to 0 if there is no daggers left");
    }

    @Test
    void powerAttack_performsRegularAttack_whenPercentChargedBelow100() {
        // arrange
        int expectedPowerAttackResult = damage;

        // act
        int actualPowerAttackResult = dagger.powerAttack();

        // assert
        assertEquals(expectedPowerAttackResult, actualPowerAttackResult, "Power attack should return default damage if percentCharged < 100%");
    }

    @Test
    void powerAttack_delivers3xDamage_setPercentChargedTo0_whenPercentChargedIs100() {
        // set
        int expectedPercent = 0;
        int expectedPowerAttackReturn = 3 * damage;
        // charge to 100%
        for (int i = 0; i < 5; i++) {
            dagger.attack();
        }

        // act
        int actualPowerAttackReturn = dagger.powerAttack();
        int actualPercent = dagger.getPercentCharged();

        // assert
        assertEquals(expectedPowerAttackReturn, actualPowerAttackReturn,
                "Power Attack should return damage * 3 if the dagger percentCharged is 100%");
        assertEquals(expectedPercent, actualPercent,
                "Power Attack should set the dagger percentCharged to 0 if it was equal to 100%");
    }


    @Test
    void powerAttack_shouldReturn0_whenDaggerCountIs0() {
        // arrange
        // set powerCharged to 100  for powerAttack
        for (int i = 0; i < 5; i++) {
            dagger.attack();
        }
        // call powerAttack to decrease number of daggers to zero
        dagger.powerAttack();
        // set powerCharged to 100  for powerAttack
        for (int i = 0; i < 5; i++) {
            dagger.attack();
        }
        int expectedPowerAttackResult = 0;

        // act
        int actualPowerAttackResult = dagger.powerAttack();

        // assert
        assertEquals(expectedPowerAttackResult, actualPowerAttackResult, "Power attack should be equal to 0 if there is no daggers left");
    }

    @Test
    void getRange_shouldReturn10() {
        // arrange
        int expectedRange = 10;

        // act
        int actualRange = dagger.getRange();

        // assert
        assertEquals(expectedRange, actualRange, "The dagger range should be equal to 10");

    }

    @Test
    void addDagger_shouldIncrease_daggerCountBy1() {
        // arrange
        int expectedDaggerCount = 2;

        // act
        dagger.addDagger();
        int actualDaggerCount = dagger.getDaggerCount();

        // assert
        assertEquals(expectedDaggerCount, actualDaggerCount, "addDagger should increase number of daggers by 1");
    }
}