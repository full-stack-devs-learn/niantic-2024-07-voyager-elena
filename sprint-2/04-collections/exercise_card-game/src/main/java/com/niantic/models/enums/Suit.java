package com.niantic.models.enums;


public enum Suit {
    SPADES("♠️"),
    HEARTS("♥️"),
    CLUBS("♣️"),
    DIAMONDS("♦️");

    private final String image;

    Suit(String img) {
        this.image = img;
    }

    public String getImage() {
        return image;
    }
}

