package com.niantic.services;

import com.niantic.models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReportService {

    public String createStudentSummaryReport(Student student) {
        createDirectory("reports");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "reports/" + today.format(formatter) + "_"
                + student.getFirstName().toLowerCase() + "_"
                + student.getLastName().toLowerCase() + ".txt";

        File file = new File(fileName);

        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Statistics for student: "
                    + student.getFirstName()
                    + " "
                    + student.getLastName());
            out.println("=".repeat(42));
            out.printf("%-36s %5d\n", "Low Score", student.getLowScore());
            out.printf("%-36s %5d\n", "High Score", student.getHighScore());
            out.printf("%-36s %3.2f\n", "Average Score", student.getAverageScore());
            out.println("-".repeat(42));
            out.println("Assignments with the lowest score");
            out.println("-".repeat(42));
            student.getLowScoreAssignments().forEach(out::println);
            out.println("-".repeat(42));
            out.println("Assignments with the highest score");
            out.println("-".repeat(42));
            student.getHighScoreAssignments().forEach(out::println);
            out.println("-".repeat(42));
            out.println("Assignments with the average score");
            out.println("-".repeat(42));
            student.getAverageScoreAssignments().forEach(out::println);
        } catch (FileNotFoundException e) {

        }

        return fileName;
    }

    private void createDirectory(String dirName) {
        File directory = new File(dirName);

        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
