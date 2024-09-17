package com.niantic.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest
{
    
    @Test
    public void dealTo_should_shouldSortCards()
    {
        // arrange
        Card card1 = new Card("Diamonds", "8");
        Card card2 = new Card("Spades", "9");
        Hand hand = new Hand();

        // act
        hand.dealTo(card1);
        hand.dealTo(card2);

        // assert
        assertEquals("Spades", hand.getCards().getFirst().getSuit(), "Because when a new card is dealt the cards in the hand should be sorted");
    }

    @Test
    public void clone_should_createDeepCopyOfHand() {
        // arrange
        Card card1 = new Card("Diamonds", "8");
        Card card2 = new Card("Spades", "9");
        Card card3 = new Card("Hearts", "Q");
        Card card4 = new Card("Hearts", "6");
        Hand hand = new Hand();
        hand.dealTo(card1);
        hand.dealTo(card2);
        hand.dealTo(card3);
        hand.dealTo(card4);

        // act - create copy
        Hand copyOfHand = hand.clone();

        // assert
        assertEquals(hand.getCards().size(), copyOfHand.getCards().size(), "Cloned hand should have the same number of cards");
        for (int i = 0; i < hand.getCards().size(); i++) {
            assertEquals(hand.getCards().get(i), copyOfHand.getCards().get(i), "Cloned hand should have the same set of cards");
        }

        // act - shuffle cards in the copy
        copyOfHand.shuffle();
        assertEquals(card2, hand.getCards().getFirst(),"Shuffling copyOfHand should not affect original hand");
        assertEquals(card4, hand.getCards().get(1),"Shuffling copyOfHand should not affect original hand");
        assertEquals(card3, hand.getCards().get(2),"Shuffling copyOfHand should not affect original hand");
        assertEquals(card1, hand.getCards().get(3),"Shuffling copyOfHand should not affect original hand");

        // act - add a new card to the copy
        Card card5 = new Card("Clubs", "10");
        copyOfHand.dealTo(card5);
        assertNotEquals(hand.getCards().size(), copyOfHand.getCards().size(),
                "Adding a new card to copyOfHand should not affect original hand");
    }

}