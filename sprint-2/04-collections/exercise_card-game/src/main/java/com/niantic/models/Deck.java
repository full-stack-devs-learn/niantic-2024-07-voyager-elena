package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.models.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> cards;

    public Deck() {
        // French-suited playing cards
        cards = new ArrayList<>();

        FaceValue[] faces = {FaceValue.TWO,
                FaceValue.THREE,
                FaceValue.FOUR,
                FaceValue.FIVE,
                FaceValue.SIX,
                FaceValue.SEVEN,
                FaceValue.EIGHT,
                FaceValue.NINE,
                FaceValue.TEN,
                FaceValue.JACK,
                FaceValue.QUEEN,
                FaceValue.KING,
                FaceValue.ACE};
        Suit[] suits = {Suit.CLUBS, Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS};

        for (var suit : suits) {
            for (var face : faces) {
                Card card = new Card(suit, face);
                cards.add(card);
            }
        }
    }

    public int getCardCount() {
        return cards.size();
    }

    public Card takeRandomCard() {
        int randIdx = (int) (Math.random() * cards.size());
        System.out.println("Deck size: " + cards.size());
        System.out.println("Random card index: " + randIdx);
        Card randomCard = cards.remove(randIdx);
        System.out.println(randomCard);
        return randomCard;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
