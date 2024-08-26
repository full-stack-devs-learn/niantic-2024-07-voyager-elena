package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.CardSet;
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
        System.out.println();
    }

    public static void printAllPlayersScores(ArrayList<Player> players) {
        System.out.println("All Players Scores");
        System.out.println("-".repeat(25));

        for (var player : players) {
            System.out.printf("%-22s %2d", player.getName(), player.getScore());
            System.out.println();
        }
        System.out.println();
    }

    public static void printPlayerTurn(Player player) {
        System.out.println();
        System.out.println(ColorCodes.BOLD + ColorCodes.BLUE + player.getName() + ", your turn!" + ColorCodes.RESET);
    }

    public static void displayPlayerCards(Player player) {
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

    public static void goFish(String name, String value) {
        System.out.println(name + " doesn't have cards with value " + value);
        System.out.println("GO FISH!");
        waitForUser();
    }

    public static void newCardMessage(Card card, Player player) {
        System.out.println();
        System.out.println(player.getName() + ", you got " + card);
    }

    public static void newCardsMessage(ArrayList<Card> cards, String name, Player player) {
        System.out.println();
        System.out.println(player.getName() + ", you got " + cards.size() + (cards.size() == 1 ? " card" : " cards") + " from " + name + ":");
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public static void waitForUser() {
        System.out.println();
        System.out.println("Press ENTER to get a card from the deck...");
        USER_INPUT.nextLine();
    }

    public static void displaySetCollectedMessage(Player player) {
        System.out.println();
        System.out.println(player.getName() + " collected new set!");
        CardSet set = player.getCollectedSets().getLast();
        System.out.println(set);
        System.out.println();
    }

    public static void declareWinner(Player winner, ArrayList<Player> players) {
        System.out.println();
        System.out.println(ColorCodes.WHITE_BACKGROUND
                + (Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + Suit.CLUBS.getImage()
                + Suit.DIAMONDS.getImage()).repeat(3) + ColorCodes.RESET);
        System.out.println(ColorCodes.RED + ColorCodes.BOLD + " ".repeat(7) + winner.getName() + " wins!" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND
                + (Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + Suit.CLUBS.getImage()
                + Suit.DIAMONDS.getImage()).repeat(3) + ColorCodes.RESET);

        printAllPlayersScores(players);

        System.out.println("Sets collected by " + winner.getName() + ":");
        // display sets collected by the winner
        for (CardSet set : winner.getCollectedSets()) {
            System.out.println(set);
            System.out.println();
        }
    }

    public static void displayTitle() {
        System.out.println(ColorCodes.WHITE_BACKGROUND + " "
                + (Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + Suit.CLUBS.getImage()
                + Suit.DIAMONDS.getImage()).repeat(7)
                + Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
//                + Suit.CLUBS.getImage()
                + " " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + " ".repeat(70) + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "      ██████\\                  ████████\\ ██\\           ██\\            " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "     ██  __██\\                 ██  _____|\\__|          ██ |           " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "     ██ /  \\__| ██████\\        ██ |      ██\\  ███████\\ ███████\\       " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "     ██ |████\\ ██  __██\\       █████\\    ██ |██  _____|██  __██\\      " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "     ██ |\\_██ |██ /  ██ |      ██  __|   ██ |\\██████\\  ██ |  ██ |     " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "     ██ |  ██ |██ |  ██ |      ██ |      ██ | \\____██\\ ██ |  ██ |     " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "     \\██████  |\\██████  |      ██ |      ██ |███████  |██ |  ██ |     " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + "      \\______/  \\______/       \\__|      \\__|\\_______/ \\__|  \\__|     " + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT + " ".repeat(70) + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND_BLUE_FONT  + " "
                + (Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + Suit.CLUBS.getImage()
                + Suit.DIAMONDS.getImage()).repeat(7)
                + Suit.SPADES.getImage()
                + Suit.HEARTS.getImage()
                + " " + ColorCodes.RESET);
    }

    public static int mainMenuSelection() {
        System.out.println();
        System.out.println(ColorCodes.BOLD + ColorCodes.BLUE + "Welcome to the Go Fish Card Game!" + ColorCodes.RESET);
        System.out.println();
        System.out.println("Please select from the following game options:");
        System.out.println();
        System.out.println("1) Computer VS Player");
        System.out.println("2) Player VS Player");
        System.out.println();

        return getUserInteger("Enter your selection: ");
    }

    public static String gameModeSelection() {
        System.out.println();
        System.out.println("Please select the game mode");
        System.out.println();
        System.out.println("1) Normal Mode");
        System.out.println("2) Testing/Cheating Mode (Player can see Computer's cards" + " \uD83D\uDE00)");
        System.out.println();

        int choice = getUserInteger("Enter your selection: ");

        if (choice == 1) {
            return "normal";
        }

        return "test";
    }

    public static int getUserInteger(String message) {
        int number = -1;

        while (number <= 0) {
            System.out.print(message);
            try {
                number = Integer.parseInt(USER_INPUT.nextLine());
                if (number > 2 || number <= 0) {
                    number = -1;
                    printInvalidSelectionMessage();
                }
            } catch (Exception e) {
                printInvalidSelectionMessage();
            }
        }

        return number;
    }

    public static String getUserString(String message) {
        System.out.print(message + ": ");
        return USER_INPUT.nextLine().strip();
    }

    public static void printInvalidSelectionMessage() {
        System.out.println("Invalid selection, please select from the available options.");
    }

}
