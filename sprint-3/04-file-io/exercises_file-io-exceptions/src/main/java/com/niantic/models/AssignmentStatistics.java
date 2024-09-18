package com.niantic.models;

import java.util.*;

public class AssignmentStatistics {
    private final Map<String, List<Integer>> assignmentsScoresMap;
    private final Set<Student> students;
    private final List<Assignment> assignments;

    public AssignmentStatistics(List<Assignment> assignments) {
        this.assignments = assignments;
        assignmentsScoresMap = new HashMap<>();
        students = new HashSet<>();

        List<Integer> scores;

        for (Assignment assignment : assignments) {
            students.add(assignment.getStudent());
            String assignmentName = assignment.getAssignmentName();
            if (assignmentsScoresMap.containsKey(assignmentName)) {
                assignmentsScoresMap.get(assignmentName).add(assignment.getScore());
            } else {
                scores = new ArrayList<>();
                scores.add(assignment.getScore());
                assignmentsScoresMap.put(assignmentName, scores);
            }
        }

        System.out.println(assignmentsScoresMap);
    }

    public int getStudentsTotalNumber() {
        return students.size();
    }

    public int getAssignmentsTotalNumber() {
        return assignmentsScoresMap.size();
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

}
