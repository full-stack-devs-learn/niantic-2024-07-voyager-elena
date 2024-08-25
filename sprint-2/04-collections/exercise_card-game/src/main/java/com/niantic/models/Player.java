package com.niantic.models;

import com.niantic.ui.UserInterface;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    protected final String name;
    protected final Hand hand;
    protected final HashSet<CardSet> collectedSets = new HashSet<>();

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

    public int getScore() {
        return collectedSets.size();
    }

    public String askForCardValue() {
        boolean isRequestValid = false;
        ArrayList<Card> cards;
        String requestedValue = "";
        while (!isRequestValid) {
            requestedValue = UserInterface.askPlayerToChooseCardValue();
            // check if this request valid, if not print error message and ask to choose again
            cards = hand.returnCardsByFaceValue(requestedValue, false);
            if (cards.isEmpty()) { // player does not have this card
                UserInterface.printWrongInputMessage();
            } else {
                isRequestValid = true;
            }
        }

        return requestedValue;
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }
}
