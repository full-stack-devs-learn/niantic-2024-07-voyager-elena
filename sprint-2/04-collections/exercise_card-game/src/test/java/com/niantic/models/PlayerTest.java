package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.models.enums.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    String playerName = "John Doe";

    @BeforeEach
    public void setup() {
        player = new Player(playerName);
    }

    @Test
    public void parameterizedConstructor_shouldCreatePlayer_withGivenName() {
        // arrange
        // act

        // assert
        assertNotNull(player, "Player object should be created");
        String actualPlayerName = player.getName();
        assertEquals(playerName, actualPlayerName, "The player should have name " + playerName + " that was set in the constructor");
    }

    @Test
    void getScore_shouldReturnZero_forJustCreatedPlayer() {
        // arrange
        // act

        int expectedScore = 0;
        int actualScore = player.getScore();

        // assert
        assertEquals(expectedScore, actualScore, "Just created Player should have score = 0");
    }

    @Test
    void hasCards_shouldReturnFalse_forJustCreatedPlayer() {
        // arrange
        // act

        boolean actualHasCardsResult = player.hasCards();

        // assert
        assertFalse(actualHasCardsResult, "Just created Player should not have cards");
    }

    @Test
    void dealTo_should_addCard() {
        // arrange
        Card card = new Card(Suit.HEARTS, FaceValue.QUEEN);

        // act
        player.dealTo(card);
        boolean actualHasCardsResult = player.hasCards();

        // assert
        assertTrue(actualHasCardsResult, "dealTo should add a card to the player's hand");
    }




}