package com.niantic.models;

import java.util.HashSet;

public class Player {
    private final String name;
    private final Hand hand;
    private final HashSet<CardSet> collectedSets = new HashSet<>();

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void dealTo(Card card) {
        hand.dealTo(card);
    }

    public void displayCards() {
        hand.displayCards();
    }

    public int getPlayerScore() {
        return collectedSets.size();
    }
}
