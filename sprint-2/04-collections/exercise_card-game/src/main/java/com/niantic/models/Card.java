package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.models.enums.Suit;
import com.niantic.ui.ColorCodes;

public class Card implements Comparable<Card> {

    private final Suit suit;
    private final FaceValue faceValue;

    public Card(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    @Override
    public String toString() {
        return ColorCodes.WHITE_BACKGROUND + faceValue.getDisplayValue() + suit.getImage() + ColorCodes.RESET;
    }

    @Override
    public int compareTo(Card o) {
        return (this.faceValue.getIntValue() - o.faceValue.getIntValue()) == 0
                ? this.suit.getOrder() - o.getSuit().getOrder()
                : this.faceValue.getIntValue() - o.faceValue.getIntValue();
    }
}
