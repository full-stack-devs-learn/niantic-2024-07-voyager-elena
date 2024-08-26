package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;

public class Player {
    protected final String name;
    protected final Hand hand;
    protected final ArrayList<CardSet> collectedSets = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return collectedSets.size();
    }

    public ArrayList<CardSet> getCollectedSets() {
        return collectedSets;
    }

    public void dealTo(Card card) {
        hand.dealTo(card);
    }

    public void displayCards() {
        hand.displayCards();
    }


    // How can I remove interaction with user from Player class?
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

    public ArrayList<Card> returnCardsByFaceValue(String value, boolean removeFromHand) {
        return hand.returnCardsByFaceValue(value, removeFromHand);
    }


    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public void addCards(ArrayList<Card> requestedCards) {
        hand.addCards(requestedCards);
    }

    public boolean checkForSet(FaceValue faceValue) {
        // player just got a card / cards with face value = value
        // check if now the player collected a set of that value
        if (hand.removeSet(faceValue.getDisplayValue())) {
            // add set to the player's collectedSets
            CardSet set = new CardSet(faceValue);
            collectedSets.add(set);
            return true;
        }

        return false;
    }
}
