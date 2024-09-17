package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>, Cloneable {
    private final String suit;
    private final String faceValue;

    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getPointValue() {
        return cardValues.get(faceValue);
    }

    public String getColor() {
        switch (suit.toLowerCase()) {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // lookup map
    private static final Map<String, Integer> cardValues = new HashMap<>() {{
        put("A", 11);
        put("K", 10);
        put("Q", 10);
        put("J", 10);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

    private static final Map<String, Integer> SUITS_ORDER = Map.of(
            "spades", 1,
            "hearts", 2,
            "diamonds", 3,
            "clubs", 4
    );

    private static final Map<String, Integer> FACE_VALUE10_ORDER = Map.of(
            "10", 0,
            "J", 1,
            "Q", 2,
            "K", 3,
            "A", 4
    );

    @Override
    public int compareTo(Card o) {
        // todo: Exercise 1: implement Comparable<Card>
        if (this.getSuit().equalsIgnoreCase(o.getSuit())) {
            // compare by values
            if (this.getPointValue() == o.getPointValue()) {
                if (this.getPointValue() < 10) {
                    return 0;
                } else {
                    return FACE_VALUE10_ORDER.get(this.getFaceValue()) - FACE_VALUE10_ORDER.get(o.getFaceValue());
                }
            } else {
                return this.getPointValue() - o.getPointValue();
            }
        } else {
            // compare by suits
            return SUITS_ORDER.get(this.getSuit().toLowerCase()) - SUITS_ORDER.get(o.getSuit().toLowerCase());
        }
    }

    @Override
    public Card clone() {
        try {
            return (Card) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return otherCard.getSuit().equalsIgnoreCase(this.suit) && otherCard.getFaceValue().equalsIgnoreCase(this.faceValue);
    }

    @Override
    public String toString() {
        return "Suite: " + suit + " FaceValue: " + faceValue;
    }
}
