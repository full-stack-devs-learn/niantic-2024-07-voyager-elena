package com.niantic.part_2_challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameCharacterTests {
    private final String name = "Iron Man";
    private final int maxEnergyLevel = 100;
    private GameCharacter character;

    @BeforeEach
    public void setup() {
        character = new GameCharacter(maxEnergyLevel, name);
    }

    @Test
    public void quiz_parameterizedConstructor_ShouldCreateGameCharacter_WithGivenNameAndMaxEnergyLevel() {
        // arrange
        // act

        // assert
        assertNotNull(character, "GameCharacter object should be created");
        assertEquals(name, character.getName(), "The GameCharacter should have name " + name + " that was set in the constructor");
        assertEquals(maxEnergyLevel, character.getMaxEnergyLevel(), "The GameCharacter should have maxEnergyLevel = " + maxEnergyLevel + " that was set in the constructor");
    }

    @Test
    public void takeHit_shouldReduceEnergyLevelByTheAmountOfDamagesSpecified_whenDamageNotGreaterThanEnergyLevel() {
        // arrange
        int damage = 30;
        int expectedEnergyLevel = character.getEnergyLevel() - damage;

        // set
        character.takeHit(damage);
        int actualEnergyLevel = character.getEnergyLevel();

        // assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel,
                "Energy level should be equal to " + expectedEnergyLevel +
                        " when character had energy level=" + maxEnergyLevel +
                        " and got damage=" + damage
        );
    }

    @Test
    public void takeHit_shouldSetEnergyLevelToZero_whenDamageGreaterThanEnergyLevel() {
        // arrange
        int damage = maxEnergyLevel + 70;
        int expectedEnergyLevel = 0;

        // set
        character.takeHit(damage);
        int actualEnergyLevel = character.getEnergyLevel();

        // assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel,
                "Energy level should be equal to " + expectedEnergyLevel +
                        " if character had energy level=" + maxEnergyLevel +
                        " and got damage=" + damage
        );
    }

    @Test
    public void heal_ShouldIncreaseEnergyLevelByTheAmountOfEnergy_whenTheResultEnergyLessThanMaxEnergyLevel() {
        // arrange
        int damage = 70;
        character.takeHit(damage);
        int amount = 30;
        int expectedEnergyLevel = maxEnergyLevel - damage + amount;

        // set
        character.heal(amount);
        int actualEnergyLevel = character.getEnergyLevel();

        // assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel,
                "Energy level should be equal to " + expectedEnergyLevel +
                        "if character had energy=" + (maxEnergyLevel - damage) +
                        "and was healed by " + amount
        );
    }

    @Test
    public void heal_ShouldSetEnergyLevelToMaxEnergy_whenTheResultEnergyGreaterThanMaxEnergyLevel() {
        // arrange
        int amount = 130;
        int damage = 50;
        character.takeHit(damage);
        int initialEnergy = maxEnergyLevel - damage;
        int expectedEnergyLevel = maxEnergyLevel;

        // set
        character.heal(amount);
        int actualEnergyLevel = character.getEnergyLevel();

        // assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel,
                "Energy level should be equal to " + expectedEnergyLevel +
                        " after healing the character with energy=" + initialEnergy +
                        " by " + amount +
                        "\nbecause energy level should never increase above the maximum level " +
                        "\nand the character maxEnergyLevel=" + maxEnergyLevel
        );
    }

    @Test
    public void heal_ShouldNotIncreaseEnergyLevel_whenEnergyLevelIsZero() {
        // arrange
        int expectedEnergyLevel = 0;
        character.takeHit(maxEnergyLevel);
        int amount = 35;

        // set
        character.heal(amount);
        int actualEnergyLevel = character.getEnergyLevel();

        // assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel,
                        "Energy level should be equal to " + expectedEnergyLevel +
                        ", character cannot heal if they knocked out"
        );
    }


}