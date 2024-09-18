package com.niantic.models;

import java.util.*;

public class AssignmentStatistics {
    private final Set<String> assignmentNames;
    private final Set<Student> students;
    private final List<Assignment> assignments;

    public AssignmentStatistics(List<Assignment> assignments) {
        this.assignments = assignments;
        assignmentNames = new HashSet<>();
        students = new HashSet<>();

        for (Assignment assignment : assignments) {
            students.add(assignment.getStudent());
            String assignmentName = assignment.getAssignmentName();
            assignmentNames.add(assignmentName);
        }
    }

    public List<String> getAssignmentNamesListSortedByName() {
        return assignmentNames.stream().sorted().toList();
    }

    public int getStudentsTotalNumber() {
        return students.size();
    }

    public int getAssignmentsTotalNumber() {
        return assignmentNames.size();
    }

    public int getLowScore() {
        return ScoresCalculator.getLowScore(assignments);
    }

    public int getHighScore() {
        return ScoresCalculator.getHighScore(assignments);
    }

    public double getAverageScore() {
        return ScoresCalculator.getAverageScore(assignments);
    }

    public List<Assignment> getLowScoreAssignments() {
        return ScoresCalculator.getLowScoreAssignments(assignments);
    }

    public List<Assignment> getHighScoreAssignments() {
        return ScoresCalculator.getHighScoreAssignments(assignments);
    }

    public List<Assignment> getAverageScoreAssignments() {
        return ScoresCalculator.getAverageScoreAssignments(assignments);
    }

    public int getAssignmentLowScore(String assignmentName) {
        return ScoresCalculator.getLowScore(
                assignments
                        .stream()
                        .filter(assignment -> assignment.getAssignmentName().equals(assignmentName))
                        .toList());
    }

    public int getAssignmentHighScore(String assignmentName) {
        return ScoresCalculator.getHighScore(
                assignments
                        .stream()
                        .filter(assignment -> assignment.getAssignmentName().equals(assignmentName))
                        .toList());
    }

    public double getAssignmentAverageScore(String assignmentName) {
        return ScoresCalculator.getAverageScore(
                assignments
                        .stream()
                        .filter(assignment -> assignment.getAssignmentName().equals(assignmentName))
                        .toList());
    }

}
