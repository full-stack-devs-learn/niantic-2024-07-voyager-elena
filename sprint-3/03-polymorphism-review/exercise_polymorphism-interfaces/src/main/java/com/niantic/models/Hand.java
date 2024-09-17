package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Cloneable
{
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getPointValue()
    {
        // return sum of all card points
        int sum = cards.stream()
                        .map(card -> card.getPointValue())
                        .reduce(0, (temp, value) -> temp + value);

        return sum;
    }

    public void sort()
    {
        // Todo: Exercise 2: implement this sort method
        Collections.sort(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getCardCount()
    {
        return cards.size();
    }


    public void dealTo(Card card)
    {
        cards.add(card);
        sort();
    }

    @Override
    public Hand clone() {
        try {
            Hand clone = (Hand) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.cards = new ArrayList<>();
            for(Card card : cards) {
                clone.dealTo(card.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
