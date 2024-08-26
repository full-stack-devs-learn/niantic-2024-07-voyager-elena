package com.niantic.models;

public class Computer extends Player {

    private static int computerNumber = 0;

    public Computer() {
        super("Computer " + ++computerNumber);
    }

    @Override
    public String askForCardValue() {
        // this computer is not very smart, so it will choose random card to ask
        int randIdx = (int) (Math.random() * hand.getNumberOfCards());
        // System.out.println("Computer hand size: " + hand.getNumberOfCards());
        // System.out.println("Random card index: " + randIdx);
        Card randomCard = hand.getCardByIndex(randIdx);
        return randomCard.getFaceValue().getDisplayValue();
    }
}
