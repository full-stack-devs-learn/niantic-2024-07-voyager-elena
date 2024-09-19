package com.niantic.ui;

import com.niantic.models.AssignmentStatistics;
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
            System.out.println("  5) All Students: display all students statistics");
            System.out.println("  6) All Assignments: display all assignments statistics");
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

        waitForUser();
    }

    public static void displayStudentAssignments(Student student) {
        System.out.println();
        System.out.println("All scores for student: "
                + student.getFirstName()
                + " "
                + student.getLastName());
        System.out.println("=".repeat(42));
        student.getAssignments().forEach(System.out::println);

        waitForUser();
    }

    public static void displayStudentStatistics(Student student) {
        System.out.println();
        System.out.println("Statistics for student: "
                + student.getFirstName()
                + " "
                + student.getLastName());
        System.out.println("=".repeat(42));
        System.out.printf("%-36s %5d\n", "Low Score", student.getLowScore());
        System.out.printf("%-36s %5d\n", "High Score", student.getHighScore());
        System.out.printf("%-36s %3.2f\n", "Average Score", student.getAverageScore());
        System.out.println("-".repeat(42));
        System.out.println("Assignments with the lowest score");
        System.out.println("-".repeat(42));
        student.getLowScoreAssignments().forEach(System.out::println);
        System.out.println("-".repeat(42));
        System.out.println("Assignments with the highest score");
        System.out.println("-".repeat(42));
        student.getHighScoreAssignments().forEach(System.out::println);
        System.out.println("-".repeat(42));
        System.out.println("Assignments with the average score");
        System.out.println("-".repeat(42));
        student.getAverageScoreAssignments().forEach(System.out::println);

        waitForUser();
    }

    public static void displayAllStudentsStatistics(AssignmentStatistics assignmentsStatistics) {
        System.out.println();
        System.out.println("All Students Statistics");
        System.out.println("=".repeat(60));
        System.out.printf("%-54s %5d\n", "Total Students", assignmentsStatistics.getStudentsTotalNumber());
        System.out.printf("%-54s %5d\n", "Total Assignments ", assignmentsStatistics.getAssignmentsTotalNumber());
        System.out.println("-".repeat(60));
        System.out.printf("%-54s %5d\n", "Low Score", assignmentsStatistics.getLowScore());
        System.out.printf("%-54s %5d\n", "High Score", assignmentsStatistics.getHighScore());
        System.out.printf("%-54s %3.2f\n", "Average Score", assignmentsStatistics.getAverageScore());
        System.out.println("-".repeat(60));
        System.out.println("Assignments with the lowest score");
        System.out.println("-".repeat(60));
        assignmentsStatistics.getLowScoreAssignments().forEach(assignment -> System.out.println(assignment.toStringWithStudent()));
        System.out.println("-".repeat(60));
        System.out.println("Assignments with the highest score");
        System.out.println("-".repeat(60));
        assignmentsStatistics.getHighScoreAssignments().forEach(assignment -> System.out.println(assignment.toStringWithStudent()));
        System.out.println("-".repeat(60));
        System.out.println("Assignments with the average score");
        System.out.println("-".repeat(60));
        assignmentsStatistics.getAverageScoreAssignments().forEach(assignment -> System.out.println(assignment.toStringWithStudent()));

        waitForUser();
    }

    public static void displayAllAssignmentsStatistics(AssignmentStatistics assignmentsStatistics) {
        System.out.println();
        System.out.println("All Assignments Statistics");
        System.out.println("=".repeat(50));
        System.out.printf("%-27s %6s %6s %8s\n", "Assignment Name", "Low", "High", "Average");
        System.out.println("=".repeat(50));
        assignmentsStatistics.getAssignmentNamesListSortedByName()
                .forEach(assignmentName ->
                        System.out.printf("%-26s %6d %6d %8.2f\n",
                                assignmentName,
                                assignmentsStatistics.getAssignmentLowScore(assignmentName),
                                assignmentsStatistics.getAssignmentHighScore(assignmentName),
                                assignmentsStatistics.getAssignmentAverageScore(assignmentName)
                        )
                );
        System.out.println();
        System.out.print("Press ENTER to get details for each assignment...");
        in.nextLine();
        assignmentsStatistics.getAssignmentNamesListSortedByName()
                .forEach(assignmentName -> {
                            System.out.println();
                            System.out.println("=".repeat(60));
                            System.out.println(assignmentName.toUpperCase());
                            System.out.println("=".repeat(60));
                            System.out.printf("%-54s %5d\n", "Total Students", assignmentsStatistics.getAssignmentStudentsTotalNumber(assignmentName));
                            System.out.println("-".repeat(60));
                            System.out.printf("%-54s %5d\n", "Low Score", assignmentsStatistics.getAssignmentLowScore(assignmentName));
                            System.out.printf("%-54s %5d\n", "High Score", assignmentsStatistics.getAssignmentHighScore(assignmentName));
                            System.out.printf("%-54s %3.2f\n", "Average Score", assignmentsStatistics.getAssignmentAverageScore(assignmentName));
                            System.out.println("-".repeat(60));
                            System.out.println("Students with the lowest score");
                            System.out.println("-".repeat(60));
                            assignmentsStatistics.getAssignmentLowScoreAssignments(assignmentName)
                                    .forEach(assignment -> System.out.println(assignment.toStringWithStudent()));
                            System.out.println("-".repeat(60));
                            System.out.println("Students with the highest score");
                            System.out.println("-".repeat(60));
                            assignmentsStatistics.getAssignmentHighScoreAssignments(assignmentName)
                                    .forEach(assignment -> System.out.println(assignment.toStringWithStudent()));
                            System.out.println("-".repeat(60));
                            System.out.println("Students with the average score");
                            System.out.println("-".repeat(60));
                            assignmentsStatistics.getAssignmentAverageScoreAssignments(assignmentName)
                                    .forEach(assignment -> System.out.println(assignment.toStringWithStudent()));
                            waitForUser();
                        }
                );
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
