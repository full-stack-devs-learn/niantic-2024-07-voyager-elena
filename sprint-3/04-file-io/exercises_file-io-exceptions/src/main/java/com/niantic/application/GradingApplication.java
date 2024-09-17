package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.Student;
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
        UserInput.displayAllFiles(files);
    }

    private void displayFileScores() {
        // todo: 2 - allow the user to select a file name
        //      load all student assignment scores from the file - display all files

        String[] files = gradesService.getFileNames();
        int choice = UserInput.displayMenuToChooseFile(files);

        String selectedFile = files[choice - 1];
        UserInput.displayMessage("You selected: " + selectedFile);

        List<Assignment> assignments = gradesService.getAssignments(selectedFile);

        if (!assignments.isEmpty()) {
            Student student = assignments.getFirst().getStudent();
            UserInput.displayStudentAssignments(student, assignments);
        } else {
            UserInput.displayMessage("There is no data in the selected file");
        }
    }

    private void displayStudentAverages() {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file
        // display student statistics (low score, high score, average score)
        String[] files = gradesService.getFileNames();
        int choice = UserInput.displayMenuToChooseFile(files);

        String selectedFile = files[choice - 1];
        UserInput.displayMessage("You selected: " + selectedFile);

        List<Assignment> assignments = gradesService.getAssignments(selectedFile);

        if (!assignments.isEmpty()) {
            Student student = assignments.getFirst().getStudent();
            UserInput.displayStudentStatistics(student);
        } else {
            UserInput.displayMessage("Sorry, there is no data to calculate statistics");
        }

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
