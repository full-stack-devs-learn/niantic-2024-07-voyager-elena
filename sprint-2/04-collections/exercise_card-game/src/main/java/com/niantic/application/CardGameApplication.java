package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Computer;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;

public class CardGameApplication {
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();

    public void run() {
        startGame();
        // for testing purposes
        UserInterface.displayAllPlayersCards(players);
        gamePlay();
        UserInterface.displayAllPlayersCards(players);
        UserInterface.printAllPlayersScores(players);
        Player winner = determineWinner();
        UserInterface.declareWinner(winner);
    }

    private Player determineWinner() {
        return players.getFirst();
    }

    private void startGame() {
        createPlayers();
        dealCards();
    }

    private void createPlayers() {
        // TODO:
        //   play with computer or with other players
        //   ask user how many players (2 - 5)
        //   ask to enter player names

        // for now there will be only two players: Player 1 and Player 2
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Computer());
        players.add(new Computer());
        players.add(new Computer());
    }

    private void dealCards() {
        deck.shuffle();
        // five cards are dealt from a standard 52-card deck to each player,
        // or seven cards if there are only two players
        int numberOfCardsToStart = 5;
        if (players.size() == 2) {
            numberOfCardsToStart = 7;
        }
        for (int i = 0; i < numberOfCardsToStart; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                player.dealTo(card);
            }
        }
    }

    private void gamePlay() {
        while (!deck.isEmpty()) {
            for (Player player : players) {
                UserInterface.printPlayerTurn(player);
                String requestedValue = player.askForCardValue();

                // since there are only two players in this game version so far,
                // skip step where player choose another player to ask cards

                Player playerToAskCards = player;
                for (var p : players) {
                    if (p != player) {
                        playerToAskCards = p;
                    }
                }
                System.out.println("Player to ask: " + playerToAskCards.getName());

                if(!player.hasCards()) {
                    UserInterface.displayNoCardsLeft(player);
                    return;
                }
            }
        }
    }



}
