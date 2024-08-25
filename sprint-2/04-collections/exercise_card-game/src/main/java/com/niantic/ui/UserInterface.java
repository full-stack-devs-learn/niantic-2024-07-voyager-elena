package com.niantic.ui;

import com.niantic.models.Player;
import com.niantic.models.enums.Suit;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner USER_INPUT = new Scanner(System.in);

    public static void displayAllPlayersCards(ArrayList<Player> players) {
        System.out.println("All Players");
        System.out.println("-".repeat(30));
        for (Player player : players) {
            System.out.println(player.getName());
            player.displayCards();
        }
    }

    public static void printAllPlayersScores(ArrayList<Player> players) {
        System.out.println("All Players Scores");
        System.out.println("-".repeat(30));

        for (var player : players) {
            System.out.print(player.getName() + ": " + player.getScore());
            System.out.println();
        }
    }

    public static void declareWinner(Player winner) {
        System.out.println();
        System.out.println(ColorCodes.WHITE_BACKGROUND
                + (Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + Suit.CLUBS.getImage()
                + Suit.DIAMONDS.getImage()).repeat(3) + ColorCodes.RESET);
        System.out.println(ColorCodes.RED + ColorCodes.BOLD + winner.getName() + " wins!" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND
                + (Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + Suit.CLUBS.getImage()
                + Suit.DIAMONDS.getImage()).repeat(3) + ColorCodes.RESET);
        System.out.println("Sets collected by " + winner.getName() + ":");
        // TODO: display sets collected by the winner
    }

    public static void printPlayerTurn(Player player) {
        System.out.println();
        System.out.println(ColorCodes.BOLD + player.getName() + ColorCodes.RESET + ", your turn!");
        System.out.println("Your cards:");
        player.displayCards();
    }

    public static String askPlayerToChooseCardValue() {
        System.out.println();
        System.out.println("Please choose a card face value you want to request");
        System.out.print("(you must have at least one card of this value in your hand): ");
        return USER_INPUT.nextLine().strip();
    }

    public static void printWrongInputMessage() {
        System.out.println("You requested value you do not have in your hand");
        System.out.println("Please try again");
    }

    public static void displayNoCardsLeft(Player player) {
        System.out.println(player.getName() + " does not have cards in their hand");
        System.out.println("GAME OVER!");
        System.out.println();
    }
}
