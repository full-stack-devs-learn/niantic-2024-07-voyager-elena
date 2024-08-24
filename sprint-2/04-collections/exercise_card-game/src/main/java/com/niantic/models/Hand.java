package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void dealTo(Card card) {
        cards.add(card);
    }

    public void displayCards() {
        sortCarts();
        for (var card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    private void sortCarts() {
        Collections.sort(cards);
    }
}
