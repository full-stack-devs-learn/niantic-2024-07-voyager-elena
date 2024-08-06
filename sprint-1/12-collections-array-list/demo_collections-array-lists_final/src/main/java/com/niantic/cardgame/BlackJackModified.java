package com.niantic.cardgame;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Hand;

import java.util.ArrayList;

/*
 This game is not Black Jack actually
 The winner is the player(players) who got the highest score after numberOfRounds rounds
 */

public class BlackJackModified {
    private Deck deck;
    private ArrayList<Hand> players;

    public BlackJackModified(ArrayList<String> names) {
        deck = new Deck();
        players = new ArrayList<>(names.size());
        for (var name : names) {
            players.add(new Hand(name));
        }
    }

    public void play(int numberOfRounds) {
        deck.shuffle();;


        for (int i = 0; i < numberOfRounds; i++) {
            if (deck.getDeckSize() >= players.size()) {
                for (var player : players) {
                    player.deal(deck.dealCard());
                }
            } else {
                System.out.println("There is not enough cards in the deck to continue");
                System.out.println("The game stopped after " + (i + 1) + " rounds" );
                break;
            }
        }

        printReport();
    }

    private int getHighestScore() {
        int maxScore = 0;

        for (var player : players) {
            maxScore = Math.max(maxScore, player.getValue());
        }

        return maxScore;
    }

    private ArrayList<Hand> getWinners() {
        int maxScore = getHighestScore();
        ArrayList<Hand> winners = new ArrayList<>();

        for (var player : players) {
            if (player.getValue() == maxScore) {
                winners.add(player);
            }
        }

        return winners;
    }

    private void printReport() {
        ArrayList<Hand> winners = getWinners();

        if (winners.size() == 1) {
            System.out.println("The winner is " + winners.getFirst().getPlayerName());
        } else {
            System.out.print("The winners are: ");
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i).getPlayerName());
                if (i < winners.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();

        System.out.printf("%-33s", "Player Name");
        System.out.printf("%12s", "Player Score\n");
        System.out.println("_".repeat(45));

        for(var player : players) {
            System.out.printf("%-33s", player.getPlayerName());
            System.out.printf("%12s", player.getValue() + "\n");
        }

        System.out.println();
    }
}
