package com.niantic.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck deck;

    @BeforeEach
    public void setup() {
        deck = new Deck();
    }

    @Test
    void isEmpty_shouldBeFalse_forNewDeck() {
        // arrange
        // act

        boolean actualIsEmptyResult = deck.isEmpty();

        // assert
        assertFalse(actualIsEmptyResult, "Just created Deck should not be empty");
    }

    @Test
    void getCardCount_shouldReturn52_forNewDeck() {
        // arrange
        // act
        int expectedCardCount = 52;
        int actualCardCount = deck.getCardCount();

        // assert
        assertEquals(expectedCardCount, actualCardCount, "Just created deck should have 52 cards");
    }

    @Test
    void drawCard_shouldReduce_cardCountByOne() {
        // arrange
        // act
        deck.drawCard();
        int expectedCardCount = 51;
        int actualCardCount = deck.getCardCount();

        // assert
        assertEquals(expectedCardCount, actualCardCount, "drawCard should reduce cards number in the deck by one");
    }

    @Test
    void isEmpty_shouldBeTrue_forEmptyDeck() {
        // arrange
        // act
        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }
        boolean actualIsEmptyResult = deck.isEmpty();

        // assert
        assertTrue(actualIsEmptyResult, "isEmpty should return True for empty deck");
    }
    
}