package com.niantic.models;

import java.util.*;

public class ScoresCalculator {

    public static int getLowScore(List<Assignment> assignments) {
        OptionalInt lowScore = assignments.stream().mapToInt(Assignment::getScore).min();
        return lowScore.isPresent() ? lowScore.getAsInt() : 0;
    }

    public static int getHighScore(List<Assignment> assignments) {
        OptionalInt highScore = assignments.stream().mapToInt(Assignment::getScore).max();
        return highScore.isPresent() ? highScore.getAsInt() : 0;
    }


    public static double getAverageScore(List<Assignment> assignments) {
        OptionalDouble averageScore = assignments.stream().mapToInt(Assignment::getScore).average();
        return averageScore.isPresent() ? averageScore.getAsDouble() : 0;
    }

    public static List<Assignment> getLowScoreAssignments(List<Assignment> assignments) {
        int lowScore = getLowScore(assignments);
        return assignments.stream().filter(assignment -> assignment.getScore() == lowScore).toList();
    }

    public static List<Assignment> getHighScoreAssignments(List<Assignment> assignments) {
        int highScore = getHighScore(assignments);
        return assignments.stream().filter(assignment -> assignment.getScore() == highScore).toList();
    }

    public static List<Assignment> getAverageScoreAssignments(List<Assignment> assignments) {
        double averageScore = getAverageScore(assignments);
        Set<Integer> scores = new HashSet<>();
        int score = (int) averageScore;
        scores.add(score);
        scores.add(score - 1);
        scores.add(score + 1);

        return assignments.stream().filter(assignment -> scores.contains(assignment.getScore())).toList();
    }
}
