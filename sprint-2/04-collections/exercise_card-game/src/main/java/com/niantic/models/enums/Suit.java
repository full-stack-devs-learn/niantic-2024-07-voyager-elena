package com.niantic.models.enums;


public enum Suit {
    SPADES("♠️", 1),
    HEARTS("♥️", 2),
    DIAMONDS("♦️", 3),
    CLUBS("♣️", 4);

    private final String image;
    private final int order;

    Suit(String img, int order) {
        this.image = img;
        this.order = order;
    }

    public String getImage() {
        return image;
    }

    public int getOrder() {
        return order;
    }
}

