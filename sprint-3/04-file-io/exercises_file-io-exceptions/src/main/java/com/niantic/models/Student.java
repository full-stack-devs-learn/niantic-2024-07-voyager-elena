package com.niantic.models;

import java.util.*;

public class Student {
    private final String firstName;
    private final String lastName;
    private final List<Assignment> assignments;

    public Student(String firstName, String lastName) {
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        assignments = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Student otherStudent = (Student) obj;
        return otherStudent.getFirstName().equals(this.firstName) && otherStudent.getLastName().equals(this.lastName);
    }
}
