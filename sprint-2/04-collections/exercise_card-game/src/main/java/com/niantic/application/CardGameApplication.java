package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Computer;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.models.enums.FaceValue;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;

public class CardGameApplication {
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    String gameMode;

    public void run() {
        startGame();
        gamePlay();
        Player winner = determineWinner();
        UserInterface.declareWinner(winner, players);
    }

    private void startGame() {
        UserInterface.displayTitle();
        int gameChoice = UserInterface.mainMenuSelection();
        createPlayers(gameChoice);
        String gameMode = UserInterface.gameModeSelection();
        dealCards();
    }

    private void createPlayers(int gameChoice) {

        // for now there will be only two players: Player 1 and Player 2
        // players.add(new Player("Player 1"));
        // players.add(new Player("Player 2"));
        // players.add(new Computer());
        // players.add(new Computer());
        // players.add(new Computer());

        // This version allows only two players
        // TODO: add opportunity play game with more players (from 2 to 5)
        int numberOfPlayers = 2;

        if (gameChoice == 1) {
            // Player vs Computer(s)
            String playerName = UserInterface.getUserString("Please enter your name");
            players.add(new Player(playerName));

            for (int i = 1; i < numberOfPlayers; i++) {
                players.add(new Computer());
            }

        } else {
            // two Players
            for (int i = 0; i < 2; i++) {
                String playerName = UserInterface.getUserString("Please enter Player " + (i + 1) + " name");
                players.add(new Player(playerName));
            }
        }
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
                boolean endOfTurn = false;
                while (!endOfTurn) {
                    UserInterface.printPlayerTurn(player);
                    UserInterface.printAllPlayersScores(players);
                    // TODO: move displaying player's cards inside player.askForCardValue()
                    //       so that human player cannot see computer's cards
                    UserInterface.displayPlayerCards(player);
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

                    // check if playerToAskCards has cards with requestedValue
                    // playerToAskCards must hand over all cards of that face value they have
                    ArrayList<Card> requestedCards = playerToAskCards.returnCardsByFaceValue(requestedValue, true);
                    FaceValue faceValueGot;
                    if (requestedCards.isEmpty()) {
                        UserInterface.goFish(playerToAskCards.getName(), requestedValue);
                        // If a player is told to “Go fish!” they pull a random card from the deck and add it to their hand.
                        Card card = deck.drawCard();
                        if (player instanceof Computer) {

                        } else {
                            UserInterface.newCardMessage(card, player);
                        }
                        player.dealTo(card);
                        faceValueGot = card.getFaceValue();
                        // After a player is told to “Go Fish!” and selects their random card, their turn ends
                        endOfTurn = true;
                    } else {
                        // add cards to player's hand
                        UserInterface.newCardsMessage(requestedCards, playerToAskCards.getName(), player);
                        player.addCards(requestedCards);
                        faceValueGot = requestedCards.getFirst().getFaceValue();
                    }
                    // check if player has a set after getting cards (from another player or from deck
                    boolean wasSetCollected = player.checkForSet(faceValueGot);
                    if (wasSetCollected) {
                        UserInterface.displaySetCollectedMessage(player);
                        UserInterface.displayPlayerCards(player);
                        if (!player.hasCards()) {
                            // Game over because play continues until one player runs out of cards
                            UserInterface.displayNoCardsLeft(player);
                            return;
                        }
                    }
                    if (!playerToAskCards.hasCards()) {
                        // Game over
                        UserInterface.displayNoCardsLeft(playerToAskCards);
                        return;
                    }
                }
            }
        }
    }

    private Player determineWinner() {
        Player winner = players.getFirst();
        int maxScore = winner.getScore();

        for (Player player : players) {
            if (player.getScore() > maxScore) {
                winner = player;
                maxScore = winner.getScore();
            }
        }

        return winner;
    }


}
