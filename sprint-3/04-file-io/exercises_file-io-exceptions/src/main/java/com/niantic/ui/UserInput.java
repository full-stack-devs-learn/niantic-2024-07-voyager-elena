package com.niantic.ui;

import com.niantic.models.Student;

import java.util.Scanner;

public class UserInput {
    protected static Scanner in = new Scanner(System.in);

    public static int homeScreenSelection() {
        boolean valid = false;
        int choice = -1;

        while (!valid) {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("-".repeat(30));
            System.out.println();
            System.out.println("  1) Display files");
            System.out.println("  2) Student: display all scores");
            System.out.println("  3) Student: display statistics");
            System.out.println("  4) Student: create summary report");
            System.out.println("  5) All Students: display average score");
            System.out.println("  6) All Assignments: display average score");
            System.out.println();
            System.out.println("  0) Exit");

            System.out.println();
            System.out.print("Please make a selection: ");

            String choiceStr = in.nextLine();

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (Exception e) {
                choice = -1;
            }
            if (choice < 0 || choice > 6) {
                displayMessage("Invalid input, please make a valid selection");
            } else {
                valid = true;
            }
        }

        return choice;
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
            System.out.print("Please select a file to create a report: ");

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

    public static void displayAllFiles(String[] files) {
        System.out.println();
        System.out.println(" All students files");
        System.out.println("=".repeat(20));

        for (var fileName : files) {
            System.out.println(fileName);
        }
    }

    public static void displayStudentAssignments(Student student) {
        System.out.println();
        System.out.println("All scores for student: "
                + student.getFirstName()
                + " "
                + student.getLastName());
        System.out.println("=".repeat(42));
        student.getAssignments().forEach(System.out::println);
    }

    public static void displayStudentStatistics(Student student) {
        System.out.println();
        System.out.println("Statistics for student: "
                + student.getFirstName()
                + " "
                + student.getLastName());
        System.out.println("=".repeat(42));
        System.out.printf("%-15s %5d \n", "Low Score", student.getLowScore());
        System.out.printf("%-15s %5d \n", "High Score", student.getHighScore());
        System.out.printf("%-15s %3.2f \n", "Average Score", student.getAverageScore());
    }

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
    }

    public static void waitForUser() {
        System.out.println();
        System.out.print("Press ENTER to continue...");
        in.nextLine();
    }

}
