package com.niantic.ui;

import java.util.Scanner;

public class UserInput {
    protected static Scanner in = new Scanner(System.in);

    public static int homeScreenSelection() {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("-".repeat(30));
        System.out.println();
        System.out.println("  1) Display files");
        System.out.println();
        System.out.println("  ------------ Individual File ------------");
        System.out.println("  2) Student: display all scores");
        System.out.println("  3) Student: display average score");
        System.out.println();
        System.out.println("  ---------- Challenge All Files ----------");
        System.out.println("  5) All Students: display average score");
        System.out.println("  6) All Assignments: display average score");
        System.out.println();
        System.out.println("  0) Exit");

        System.out.println();
        System.out.print("Please make a selection: ");

        return Integer.parseInt(in.nextLine());
    }

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
    }

    public static int displayMenuToChooseFile(String[] files) {
        int n = files.length;
        boolean valid = false;
        int choice = 0;

        while (!valid) {
            System.out.println();
            System.out.println(" All students files");
            System.out.println("=".repeat(20));

            for (int i = 0; i < n; i++) {
                System.out.printf("%2d) %s \n", i + 1, files[i]);
            }

            System.out.println();
            System.out.print("Please select a file: ");

            String choiceStr = in.nextLine();

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (Exception e) {
                choice = 0;
            }
            if (choice <= 0 || choice > n) {
                displayMessage("Invalid input, please select a valid option");
            } else {
                valid = true;
            }

        }
        return choice;
    }

}
