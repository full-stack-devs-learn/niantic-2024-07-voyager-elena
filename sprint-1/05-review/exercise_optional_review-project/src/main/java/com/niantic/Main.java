package com.niantic;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner userInput = new Scanner(System.in);
    private static int[] scores = new int[0];
    private static final String APP_NAME = "Awesome Test Score Calculator";

    public static void main(String[] args) {
        while (true) {
            int choice = getHomeSelection();

            switch (choice) {
                case 1:
                    createNewTestScores();
                    break;
                case 2:
                    calculateAverage();
                    break;
                case 3:
                    findHighestScore();
                    break;
                case 4:
                    findLowestScore();
                    break;
                case 5:
                    printAllScores();
                    break;
                case 0:
                    System.out.println("Thanks for using our " + APP_NAME + "!");
                    System.out.println("Have a great day!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection! Please try again");
                    break;
            }
        }
    }

    public static int getHomeSelection() {
        System.out.println();
        System.out.println("Welcome to our " + APP_NAME + "!");
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Enter new test scores");
        System.out.println("2) Calculate the class average");
        System.out.println("3) Find the highest score");
        System.out.println("4) Find the lowest score");
        System.out.println("5) Print all scores");
        System.out.println("0) Exit");
        System.out.println();
        System.out.print("Please select an option: ");
        int choice;
        try {
            choice = Integer.parseInt(userInput.nextLine());
        } catch (Exception e) {
            choice = -1;
        }
        return choice;
    }

    private static void createNewTestScores() {
        int arraySize = getPositiveInteger("Please enter number of test scores you want to enter: ");
        scores = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            scores[i] = getNonNegativeInteger("Please enter test score " + (i + 1) + ": ");
        }
    }

    private static int getPositiveInteger(String message) {
        int number = -1;

        while (number <= 0) {
            System.out.print(message);
            try {
                number = Integer.parseInt(userInput.nextLine());
                if (number <= 0) {
                    printInvalidInputMessage(false);
                }
            } catch (Exception e) {
                printInvalidInputMessage(false);
                number = -1;
            }
        }

        return number;
    }

    private static int getNonNegativeInteger(String message) {
        int number = -1;

        while (number < 0) {
            System.out.print(message);
            try {
                number = Integer.parseInt(userInput.nextLine());
                if (number < 0) {
                    printInvalidInputMessage(true);
                }
            } catch (Exception e) {
                printInvalidInputMessage(true);
                number = -1;
            }
        }

        return number;
    }

    private static void printInvalidInputMessage(boolean isZeroAllowed) {
        System.out.println("Sorry, invalid input!");
        System.out.println("The entered number should be a " + (isZeroAllowed ? "nonnegative" : "positive") + " integer number");
    }

    private static void calculateAverage() {
        if (scores.length == 0) {
            printNoScoresMessage("calculate the average");
            return;
        }
        double average = 0;

        for (int score : scores) {
            average += score;
        }

        average /= scores.length;
        average = Math.round(average * 100) / 100.0;
        System.out.println("The class average (rounded to two decimal points): " + average);
    }

    private static void printNoScoresMessage(String option) {
        System.out.println("Sorry, there are no test scores to " + option);
        System.out.println("Please enter test scores first");
    }

    private static void findHighestScore() {
        if (scores.length == 0) {
            printNoScoresMessage("find the highest score");
            return;
        }

        int maxScore = scores[0];
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }

        System.out.println("The highest score: " + maxScore);
    }

    private static void findLowestScore() {
        if (scores.length == 0) {
            printNoScoresMessage("find the lowest score");
            return;
        }

        int minScore = scores[0];
        for (int score : scores) {
            minScore = Math.min(minScore, score);
        }

        System.out.println("The lowest score: " + minScore);
    }

    private static void printAllScores() {
        if (scores.length == 0) {
            printNoScoresMessage("print");
            return;
        }
        // for testing purpose
        // System.out.println(Arrays.toString(scores));

        System.out.print("Test scores:");
        for (int score : scores) {
            System.out.print(" " + score);
        }
        System.out.println();
    }
}