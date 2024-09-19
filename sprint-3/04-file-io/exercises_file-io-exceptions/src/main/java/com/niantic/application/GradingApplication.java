package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;
import com.niantic.models.Student;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.services.LogService;
import com.niantic.services.ReportService;
import com.niantic.ui.UserInput;

import java.util.*;

public class GradingApplication implements Runnable {
    private final GradesService gradesService = new GradesFileService();
    private final ReportService reportService = new ReportService();
    private final LogService applicationLogger = new LogService("application");

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
                    displayStudentStatistics();
                    break;
                case 4:
                    createStudentSummaryReport();
                    break;
                case 5:
                    displayAllStudentStatistics();
                    break;
                case 6:
                    createAllStudentsReport();
                    break;
                case 7:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Program ending... Have a great day!");
                    applicationLogger.logMessage("Exit program");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles() {
        // todo: 1 - get and display all student file names

        String[] files = gradesService.getFileNames();
        applicationLogger.logMessage("Display list of all files");
        UserInput.displayAllFiles(files);
    }

    private void displayFileScores() {
        // todo: 2 - allow the user to select a file name
        //      load all student assignment scores from the file - display all files

        String[] files = gradesService.getFileNames();
        applicationLogger.logMessage("Display menu to chose a file");
        int choice = UserInput.displayMenuToChooseFile(files);

        String selectedFile = files[choice - 1];
        UserInput.displayMessage("You selected: " + selectedFile);

        Student student = gradesService.getStudentAssignments(selectedFile);

        if (!student.getAssignments().isEmpty()) {
            applicationLogger.logMessage("Display list of all assignments for student: " + student.getFullName());
            UserInput.displayStudentAssignments(student);
        } else {
            applicationLogger.logMessage("Display data not found message");
            UserInput.displayMessage("There is no data in the selected file");
        }
    }

    private void displayStudentStatistics() {
        // todo: 3 - allow the user to select a file name
        //      load all student assignment scores from the file
        //      display student statistics (low score, high score, average score)
        String[] files = gradesService.getFileNames();
        applicationLogger.logMessage("Display menu to chose a file");
        int choice = UserInput.displayMenuToChooseFile(files);

        String selectedFile = files[choice - 1];
        UserInput.displayMessage("You selected: " + selectedFile);

        Student student = gradesService.getStudentAssignments(selectedFile);

        if (!student.getAssignments().isEmpty()) {
            applicationLogger.logMessage("Display statistics for student: " + student.getFullName());
            UserInput.displayStudentStatistics(student);
        } else {
            applicationLogger.logMessage("Display data not found message");
            UserInput.displayMessage("Sorry, there is no data to calculate statistics");
        }
    }

    private void createStudentSummaryReport() {
        String[] files = gradesService.getFileNames();
        applicationLogger.logMessage("Display menu to chose a file");
        int choice = UserInput.displayMenuToChooseFile(files);

        String selectedFile = files[choice - 1];
        UserInput.displayMessage("You selected: " + selectedFile);

        Student student = gradesService.getStudentAssignments(selectedFile);

        if (!student.getAssignments().isEmpty()) {
            String reportFileName = reportService.createStudentSummaryReport(student);
            applicationLogger.logMessage("Create report for student: " + student.getFullName());
            UserInput.displayMessage("Report for " + student.getFullName() + " was created: " + reportFileName);
        } else {
            applicationLogger.logMessage("Display data not found message");
            UserInput.displayMessage("There is no data in the selected file");
        }
    }

    private void displayAllStudentStatistics() {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        //      display the statistics for all scores
        //      (low score, high score, average score, number of students, number of assignments)

        String[] files = gradesService.getFileNames();
        List<Assignment> allAssignments = gradesService.getAllAssignments(files);
        AssignmentStatistics assignmentsStatistics = new AssignmentStatistics(allAssignments);
        applicationLogger.logMessage("Display all students statistics");
        UserInput.displayAllStudentsStatistics(assignmentsStatistics);
    }

    private void displayAssignmentStatistics() {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        //      display the statistics for each assignment
        //      (assignment name, low score, high score, average score)
        //      this one could take some time
        String[] files = gradesService.getFileNames();
        List<Assignment> allAssignments = gradesService.getAllAssignments(files);
        AssignmentStatistics assignmentsStatistics = new AssignmentStatistics(allAssignments);
        applicationLogger.logMessage("Display all assignments statistics");
        UserInput.displayAllAssignmentsStatistics(assignmentsStatistics);
    }

    private void createAllStudentsReport() {
        String[] files = gradesService.getFileNames();
        List<Assignment> allAssignments = gradesService.getAllAssignments(files);
        AssignmentStatistics assignmentsStatistics = new AssignmentStatistics(allAssignments);
        String reportFileName = reportService.createAllStudentsReport(assignmentsStatistics);
        applicationLogger.logMessage("Create all students report");
        UserInput.displayMessage("Report for all students was created: " + reportFileName);
    }

}
