package com.niantic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {

    private Bow bow;
    // name taken from this website https://www.fantasynamegenerators.com/bow-names.php
    private final String bowName = "Archangel";
    private final int damage = 1;
    private final int quiverSize = 10;
    private final String standardType = "standard";
    private final String poisonType = "poison";
    private final String explosiveType = "explosive";

    @Test
    public void parameterizedConstructor_shouldCreateBow_withStandardArrows() {
        // arrange
        // act
        bow = new Bow(bowName, damage, standardType, quiverSize);
        String actualName = bow.getName();
        int actualDamage = bow.getDamage();
        String actualArrowType = bow.getArrowType();
        int actualQuiverSize = bow.getQuiverSize();
        int actualArrowCount = bow.getArrowCount();

        // assert
        assertNotNull(bow, "Bow object should be created");
        assertEquals(bowName, actualName, "The bow name should be" + bowName);
        assertEquals(damage, actualDamage, "The bow base/default damage should be equal to " + damage);
        assertEquals(standardType, actualArrowType, "Arrow type should be '" + standardType + "'");
        assertEquals(quiverSize, actualQuiverSize, "Quiver size should be equal to " + quiverSize);
        assertEquals(quiverSize, actualArrowCount, "Arrow count should be equal to " + quiverSize);
    }

    @Test
    public void parameterizedConstructor_shouldCreateBow_withPoisonArrows() {
        // arrange
        // act
        bow = new Bow(bowName, damage, poisonType, quiverSize);
        String actualName = bow.getName();
        int actualDamage = bow.getDamage();
        String actualArrowType = bow.getArrowType();
        int actualQuiverSize = bow.getQuiverSize();
        int actualArrowCount = bow.getArrowCount();

        // assert
        assertNotNull(bow, "Bow object should be created");
        assertEquals(bowName, actualName, "The bow name should be" + bowName);
        assertEquals(damage, actualDamage, "The bow base/default damage should be equal to " + damage);
        assertEquals(poisonType, actualArrowType, "Arrow type should be '" + poisonType + "'");
        assertEquals(quiverSize, actualQuiverSize, "Quiver size should be equal to " + quiverSize);
        assertEquals(quiverSize, actualArrowCount, "Arrow count should be equal to " + quiverSize);
    }

    @Test
    public void parameterizedConstructor_shouldCreateBow_withExplosiveArrows() {
        // arrange
        // act
        bow = new Bow(bowName, damage, explosiveType, quiverSize);
        String actualName = bow.getName();
        int actualDamage = bow.getDamage();
        String actualArrowType = bow.getArrowType();
        int actualQuiverSize = bow.getQuiverSize();
        int actualArrowCount = bow.getArrowCount();

        // assert
        assertNotNull(bow, "Bow object should be created");
        assertEquals(bowName, actualName, "The bow name should be" + bowName);
        assertEquals(damage, actualDamage, "The bow base/default damage should be equal to " + damage);
        assertEquals(explosiveType, actualArrowType, "Arrow type should be '" + explosiveType + "'");
        assertEquals(quiverSize, actualQuiverSize, "Quiver size should be equal to " + quiverSize);
        assertEquals(quiverSize, actualArrowCount, "Arrow count should be equal to " + quiverSize);
    }

    @Test
    public void parameterizedConstructor_shouldThrowException_withWrongArrowType() {
        String expectedMessage = "Invalid arrow type: Ice";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Bow(bowName, damage, "Ice", quiverSize),
                "Should throw IllegalArgumentException when arrowType is not standard, poison or explosive"
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getRange_shouldReturn20() {
        // arrange
        bow = new Bow(bowName, damage, standardType, quiverSize);
        int expectedRange = 20;

        // act
        int actualRange = bow.getRange();

        // assert
        assertEquals(expectedRange, actualRange, "The bow range should be equal to 20");
    }

    @Test
    void attack_shouldReturn_defaultDamage_forStandardArrows() {
        // arrange
        bow = new Bow(bowName, damage, standardType, quiverSize);
        int expectedAttackResult = damage;

        // act
        int actualAttackResult = bow.attack();

        // assert
        assertEquals(expectedAttackResult, actualAttackResult, "Attack with " + standardType + " arrow should return default damage");
    }

    @Test
    void attack_shouldReturn_2xDamage_forPoisonArrows() {
        // arrange
        bow = new Bow(bowName, damage, poisonType, quiverSize);
        int expectedAttackResult = 2 * damage;

        // act
        int actualAttackResult = bow.attack();

        // assert
        assertEquals(expectedAttackResult, actualAttackResult, "Attack with " + poisonType + " arrow should return default damage");
    }

    @Test
    void attack_shouldReturn_3xDamage_forExplosiveArrows() {
        // arrange
        bow = new Bow(bowName, damage, explosiveType, quiverSize);
        int expectedAttackResult = 3 * damage;

        // act
        int actualAttackResult = bow.attack();

        // assert
        assertEquals(expectedAttackResult, actualAttackResult, "Attack with " + explosiveType + " arrow should return default damage");
    }

    @Test
    void powerAttack_performsRegularAttack_whenPercentChargedBelow100() throws InterruptedException {
        // arrange
        bow = new Bow(bowName, damage, standardType, quiverSize);
        int expectedPowerAttackResult = damage;

        // act
        int actualPowerAttackResult = bow.powerAttack();

        // assert
        assertEquals(expectedPowerAttackResult, actualPowerAttackResult, "Power attack should return default damage if percentCharged < 100%");
    }

    @Test
    void powerAttack_performsDeliversDoubleAttackPower_whenPercentChargedIs100() throws InterruptedException {
        // arrange
        bow = new Bow(bowName, damage, standardType, quiverSize);
        int expectedPowerAttackResult = 2 * damage;


        // act
        // wait 2 * 5 seconds to charge bow
        TimeUnit.SECONDS.sleep(10);
        int actualPowerAttackResult = bow.powerAttack();

        // assert
        assertEquals(expectedPowerAttackResult, actualPowerAttackResult, "Power attack should deliver double attack power when percentCharged = 100%");
    }

}