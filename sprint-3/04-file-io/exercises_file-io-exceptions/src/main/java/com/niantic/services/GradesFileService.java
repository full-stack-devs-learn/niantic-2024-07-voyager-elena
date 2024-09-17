package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.Student;

import java.io.File;
import java.util.*;

public class GradesFileService implements GradesService {

    @Override
    public String[] getFileNames() {
        File directory = new File("files");
        String[] files = directory.list();
        assert files != null; // ? IntelliJ insists I need this
        Arrays.sort(files);

        return files;
    }

    @Override
    public Student getStudentAssignments(String fileName) {
        List<Assignment> assignments = new ArrayList<>();

        String[] studentFullName = parseStudentName(fileName);
        String studentFirstName = studentFullName[0];
        String studentLastName = studentFullName[1];
        Student student = new Student(studentFirstName, studentLastName);

        File file = new File("files/" + fileName);

        try (Scanner reader = new Scanner(file)) {
            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                var columns = line.split(",");

                int number = Integer.parseInt(columns[0]);

                String firstName = columns[1];
                String lastName = columns[2];
                if (!(firstName.equalsIgnoreCase(student.getFirstName()) && lastName.equalsIgnoreCase(student.getLastName()))) {
                    // have wrong student data in the file;
                    // skip this line? added wrong name to student_3_laura_brown to test
                    continue;
                }

                String assignmentName = columns[3];
                int score = Integer.parseInt(columns[4]);

                assignments.add(new Assignment(number, student, assignmentName, score));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (!assignments.isEmpty()) {
            Collections.sort(assignments);
            student.getAssignments().addAll(assignments);
        }

        return student;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames) {
        List<Assignment> allAssignments = new ArrayList<>();

        return allAssignments;
    }

    private String[] parseStudentName(String fileName) {
        return fileName.replace(".csv", "")
                .substring(10)
                .split("_");
    }
}
