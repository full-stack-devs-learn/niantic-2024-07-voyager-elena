package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    private Sword sword;
    private final String swordName = "Excalibur";
    private final int damage = 10;

    @BeforeEach
    public void setup() {
        sword = new Sword(swordName, damage);
    }

    @Test
    public void parameterizedConstructor_ShouldCreateSwordCorrecty_withGivenNameAndDamage() {
        // arrange
        String expectedName = swordName;
        int expectedDamage = damage;
        int expectedPercentCharged = 0;

        // act

        // assert
        assertNotNull(sword, "Sword object should be created");
        assertEquals(expectedName, sword.getName(), "The sword name should be" + expectedName);
        assertEquals(expectedDamage, sword.getDamage(), "The sword damage should be equal to " + expectedDamage);
        assertEquals(expectedPercentCharged, sword.getPercentCharged(), "The sword percentCharged should be equal to " + expectedPercentCharged);
    }

    @Test
    void getRange_shouldReturn1() {
        int expectedRange = 1;

        assertEquals(expectedRange, sword.getRange());
    }

    @Test
    void attack_shouldReturn_defaultDamage() {
        // arrange
        int expectedAttackReturn = damage;

        // act
        int actualAttackReturn = sword.attack();

        // assert
        assertEquals(expectedAttackReturn, actualAttackReturn, "Each attack should deliver the default damage, that is " + damage);
    }

    @Test
    void attack_shouldAdd10_toPercentCharged_whenPercentChargedBelow100() {
        int expectedPercent = 0;
        int actualPercent = sword.getPercentCharged();

        for (int i = 0; i < 10; i++) {
            sword.attack();
            expectedPercent += 10;
            actualPercent = sword.getPercentCharged();
            assertEquals(expectedPercent, actualPercent, "percentCharged should be equal to "
                    + expectedPercent + " after " + (i + 1) + " attack" + (i > 0 ? "s" : ""));
        }
    }

    @Test
    void attack_shouldNotChangePercentCharged_whenPercentChargedIs100() {
        int expectedPercent = 100;

        for (int i = 0; i < 20; i++) {
            sword.attack();
        }

        int actualPercent = sword.getPercentCharged();
        assertEquals(expectedPercent, actualPercent, "percentCharged cannot exceed 100%");
    }

    @Test
    void powerAttack_performsRegularAttack_whenPercentChargedBelow50() {
        // set
        int expectedPercent = 0;
        int expectedPowerAttackReturn = damage;

        for (int i = 0; i < 3; i++) {
            sword.attack();
            expectedPercent += 10;
        }

        // act
        int actualPowerAttackReturn = sword.powerAttack();
        expectedPercent += 10;
        int actualPercent = sword.getPercentCharged();

        // assert
        assertEquals(expectedPowerAttackReturn, actualPowerAttackReturn,
                "Power Attack should return default damage if the sword percentCharged is below 50%");
        assertEquals(expectedPercent, actualPercent,
                "Power Attack should increase the sword percentCharged by 10 if it was below 50%");
    }

    @Test
    void powerAttack_deliversDoubleDamage_decreasesPercentChargedBy50_whenPercentChargedGreater50Less100() {
        // set
        int expectedPercent = 0;
        int expectedPowerAttackReturn = 2 * damage;

        for (int i = 0; i < 7; i++) {
            sword.attack();
            expectedPercent += 10;
        }

        // act
        int actualPowerAttackReturn = sword.powerAttack();
        expectedPercent -= 50;
        int actualPercent = sword.getPercentCharged();

        // assert
        assertEquals(expectedPowerAttackReturn, actualPowerAttackReturn,
                "Power Attack should return double damage if the sword percentCharged > 50% and < 100%");
        assertEquals(expectedPercent, actualPercent,
                "Power Attack should decrease the sword percentCharged by 50 if it was > 50% and < 100%");
    }

    @Test
    void powerAttack_delivers4xDamage_setPercentChargedTo0_whenPercentChargedIs100() {
        // set
        int expectedPercent = 0;
        int expectedPowerAttackReturn = 4 * damage;

        for (int i = 0; i < 10; i++) {
            sword.attack();
        }

        // act
        int actualPowerAttackReturn = sword.powerAttack();
        int actualPercent = sword.getPercentCharged();

        // assert
        assertEquals(expectedPowerAttackReturn, actualPowerAttackReturn,
                "Power Attack should return damage * 4 if the sword percentCharged is 100%");
        assertEquals(expectedPercent, actualPercent,
                "Power Attack should set the sword percentCharged to 0 if it was equal to 100%");
    }

}