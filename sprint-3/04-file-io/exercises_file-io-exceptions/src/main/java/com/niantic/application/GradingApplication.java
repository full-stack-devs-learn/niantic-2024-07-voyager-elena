package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.util.List;

public class GradingApplication implements Runnable {
    private final GradesService gradesService = new GradesFileService();

    public void run() {
        while (true) {
            int choice = UserInput.homeScreenSelection();
            switch (choice) {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    displayAllStudentStatistics();
                    break;
                case 5:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
            UserInput.waitForUser();
        }
    }

    private void displayAllFiles() {
        // todo: 1 - get and display all student file names
        String[] files = gradesService.getFileNames();

        System.out.println();
        System.out.println(" All students files");
        System.out.println("=".repeat(20));

        for (var fileName : files) {
            System.out.println(fileName);
        }
    }

    private void displayFileScores() {
        // todo: 2 - allow the user to select a file name
        //      load all student assignment scores from the file - display all files

        String[] files = gradesService.getFileNames();
        int choice = UserInput.displayMenuToChooseFile(files);
        String selectedFile = files[choice - 1];
        System.out.println("You selected: " + selectedFile);

        List<Assignment> assignments = gradesService.getAssignments(selectedFile);
        if (!assignments.isEmpty()) {
            System.out.println();
            System.out.println("All scores for student: "
                    + assignments.getFirst().getStudent().getFirstName()
                    + " "
                    + assignments.getFirst().getStudent().getLastName());
            System.out.println("=".repeat(42));
        }
        assignments.forEach(System.out::println);
    }

    private void displayStudentAverages() {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)

    }

    private void displayAllStudentStatistics() {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics() {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

}
