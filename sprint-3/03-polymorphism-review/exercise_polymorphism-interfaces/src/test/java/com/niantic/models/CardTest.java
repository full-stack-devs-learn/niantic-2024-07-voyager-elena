package com.niantic.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{

    @Test
    public void compareTo_should_compareCardSuits()
    {
        // arrange
        Card card1 = new Card("Diamonds", "8");
        Card card2 = new Card("Spades", "9");
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        // act
        Collections.sort(cards);

        // assert
        assertEquals("Spades", cards.getFirst().getSuit(), "Because cards should be sorted by suit first");
    }

    @Test
    public void compareTo_should_compareCardValues()
    {
        // arrange
        Card card1 = new Card("Spades", "8");
        Card card2 = new Card("Spades", "2");
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        // act
        Collections.sort(cards);

        // assert
        assertEquals("2", cards.getFirst().getFaceValue(), "Because cards should be sorted by value if the suit is the same");
    }

    @Test
    public void compareTo_should_compareCardFaceValues()
    {
        // arrange
        Card card1 = new Card("Spades", "K");
        Card card2 = new Card("Spades", "Q");
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        // act
        Collections.sort(cards);

        // assert
        assertEquals("Q", cards.getFirst().getFaceValue(), "Because card face values should be sorted");
    }

    @Test
    public void clone_should_createDeepCopyOfCard() {
        // arrange
        Card card = new Card("Spades", "K");

        // act
        Card copyOfCard = card.clone();

        // assert
        assertEquals(card.getSuit(), copyOfCard.getSuit(), "Cloned card should have the same suit");
        assertEquals(card.getFaceValue(), copyOfCard.getFaceValue(), "Cloned card should have the same face value");
    }

    @Test
    public void equals_should_returnTrue_ifCardsEqual() {
        // arrange
        Card card1 = new Card("Spades", "K");
        Card card2 = new Card("Spades", "K");

        // act
        boolean actualResult = card1.equals(card2);

        // assert
        assertTrue(actualResult, "Equals should return true for the same card");
    }

    @Test
    public void equals_should_returnFalse_forDifferentCards() {
        // arrange
        Card card1 = new Card("Spades", "K");
        Card card2 = new Card("Spades", "Q");

        // act
        boolean actualResult = card1.equals(card2);

        // assert
        assertFalse(actualResult, "Equals should return false for different cards");
    }


}