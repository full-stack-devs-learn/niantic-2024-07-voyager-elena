package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest extends ReflectionBase<Knight> {
    Class<Knight> knightClass;
    Constructor constructor;
    Method getArmor;
    Method attack;
    Method levelUp;
    Method getHealth;
    Method getLevel;

    @BeforeEach
    void setup() {
        knightClass = Knight.class;
        constructor = getConstructor(knightClass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        getArmor = getMethod(knightClass, "getArmor");
        attack = getMethod(knightClass, "attack", Character.class);
        levelUp = getMethod(knightClass, "levelUp");
        getHealth = getMethod(knightClass, "getHealth");
        getLevel = getMethod(knightClass, "getLevel");

    }

    @Test
    public void knight_should_extendCharacter() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, 5);

        // act
        assertInstanceOf(Character.class, knightArthur, "\nKnight should extend Character");
    }

    @Test
    public void knight_shouldHave_correctConstructor() {
        // arrange
        // act

        // assert
        assertNotNull(constructor, "\nKnight should have a public constructor with (String name, int health, int level, int experience, int armor)");
    }

    @Test
    public void knight_shouldHave_getArmor() {
        // arrange
        // act

        // assert
        assertNotNull(getArmor, "\nKnight should have a getArmor() getter method");
    }

    @Test
    public void knight_shouldNotHave_setArmor() {
        // arrange
        // act
        var method = getMethod(knightClass, "setArmor", Integer.TYPE);

        // assert
        assertNull(method, "\nKnight should NOT have a setArmor(int armor) setter method");
    }

    @Test
    public void attack_should_useBaseCharacterLogic() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, 5);
        var enemy = new Character("Villain", 50, 1, 100);

        // act
        attack.invoke(knightArthur, enemy);

        // assert
        var expectedHealth = 40;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the Knight's attack should use the base Character attack logic.");

    }

    @Test
    public void levelUp_should_increase_healthLevelAndArmor() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, 5);

        // act
        levelUp.invoke(knightArthur);

        // assert
        var expectedHealth = 50 + 10;
        var expectedLevel = 2;
        var expectedArmor = 10; // 5 + 5

        var actualHealth = getHealth.invoke(knightArthur);
        var actualLevel = getLevel.invoke(knightArthur);
        var actualArmor = (int) getArmor.invoke(knightArthur);

        assertEquals(expectedHealth, actualHealth, "Because the knight leveled up which should have added health.");
        assertEquals(expectedLevel, actualLevel, "Because the knight leveled up.");
        assertEquals(expectedArmor, actualArmor, "Because the knight leveled up which should have added armor (+5).");
    }

    @Test
    public void levelUp_shouldNot_increase_healthLevelOrArmor_forDefeatedWizard() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 0, 1, 100, 5);

        // act
        levelUp.invoke(knightArthur);

        // assert
        var expectedHealth = 0;
        var expectedLevel = 1;
        var expectedArmor = 5;

        var actualHealth = getHealth.invoke(knightArthur);
        var actualLevel = getLevel.invoke(knightArthur);
        var actualArmor = (int) getArmor.invoke(knightArthur);

        assertEquals(expectedHealth, actualHealth, "Because defeated knight should NOT have leveled up.");
        assertEquals(expectedLevel, actualLevel, "Because defeated knight should NOT have leveled up.");
        assertEquals(expectedArmor, actualArmor, "Because defeated knight should NOT have leveled up.");
    }

    @Test
    public void knight_shouldHave_SpecialAbilityOverridden() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, 5);
        String expectedSpecialAbility = "Armor Shield";

        // act
        var specialAbility = getMethod(knightClass, "specialAbility");

        // assert
        assertNotNull(specialAbility, "\nKnight should have a specialAbility method");
        assertEquals(expectedSpecialAbility, (String) specialAbility.invoke(knightArthur), "Knight's special ability should be \"Armor Shield\"");
    }

    @Test
    public void takeDamage_shouldTakeArmorInAccount_whenDamageIsMoreThanArmor() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, 5);
        var enemy = new Character("Villain", 50, 1, 100);

        //act
        enemy.attack((Character) knightArthur);

        int expectedHealth = 45; // (50 - (10 - 5));
        int actualHealth = (int) getHealth.invoke(knightArthur);

        // assert
        assertEquals(expectedHealth, actualHealth, "The Knight's armor should reduce damage gotten by " + (int) getArmor.invoke(knightArthur));
    }

    @Test
    public void takeDamage_shouldNot_changeArmor() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, 5);
        int armorBefore = (int) getArmor.invoke(knightArthur);
        int expectedArmor = armorBefore;

        var enemy = new Character("Villain", 50, 1, 100);

        //act
        enemy.attack((Character) knightArthur);
        int actualArmor = (int) getArmor.invoke(knightArthur);

        // assert
        assertEquals(expectedArmor, actualArmor, "The Knight's takeDamage method should not change armor");
    }


    // my attempt to create ParameterizedTest
    // parameter - knightArmor
    @ParameterizedTest
//    @CsvSource({
//            "0",
//            "1",
//            "5",
//            "10",
//            "20"
//    })
    @ValueSource(ints = {0, 1, 5, 10, 15}) // found example with ValueSource here https://www.baeldung.com/parameterized-tests-junit-5
    public void takeDamage_shouldTakeArmorInAccount(int armor) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // arrange
        var knightArthur = constructor.newInstance("Arthur", 50, 1, 100, armor);
        var enemy = new Character("Villain", 50, 1, 100);

        //act
        enemy.attack((Character) knightArthur);

        int expectedHealth = 50 - Math.max((10 - armor), 0);    // attackDamage = 10, but I cannot get this value here,
                                                                // it is protected so I have to hardcode this value
        int actualHealth = (int) getHealth.invoke(knightArthur);

        // assert
        assertEquals(expectedHealth, actualHealth, "The Knight's armor should reduce damage gotten by " + (int) getArmor.invoke(knightArthur));
    }

}
