package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.models.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class CardSet {
    private final FaceValue setValue;
    private final ArrayList<Card> cards;

    public CardSet(FaceValue faceValue) {
        this.setValue = faceValue;

        Suit[] suits = {Suit.CLUBS, Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS};
        cards = new ArrayList<>();

        for (var suit : suits) {
            cards.add(new Card(suit, faceValue));
        }

        Collections.sort(cards);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
            if (i != cards.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
