package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.models.enums.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private Hand hand;

    @BeforeEach
    public void setup() {
        hand = new Hand();
    }

    @Test
    public void isEmpty_returnsTrue_forJustCreatedHand() {
        // arrange
        // act
        boolean actualResult = hand.isEmpty();

        // assert
        assertTrue(actualResult, "Just created Hand should be empty");
    }

    @Test
    public void dealTo_shouldIncrease_numberOfCards() {
        // arrange
        // act
        Card card = new Card(Suit.CLUBS, FaceValue.KING);
        hand.dealTo(card);
        int expectedNumberOfCards = 1;
        int actualNumberOfCards = hand.getNumberOfCards();

        // assert
        assertEquals(expectedNumberOfCards, actualNumberOfCards, "dealTo should increase number of cards by 1");


    }


}