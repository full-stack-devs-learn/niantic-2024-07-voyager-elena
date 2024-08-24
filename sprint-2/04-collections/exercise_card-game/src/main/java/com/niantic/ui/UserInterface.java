package com.niantic.ui;

import com.niantic.models.Player;
import com.niantic.models.enums.Suit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private final Scanner USER_INPUT = new Scanner(System.in);

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
            System.out.print(player.getName() + ": " + player.getPlayerScore());
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
}
