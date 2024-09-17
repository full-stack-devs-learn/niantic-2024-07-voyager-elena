package com.niantic.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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
        OptionalInt lowScore = assignments.stream().mapToInt(Assignment::getScore).min();
        return lowScore.isPresent() ? lowScore.getAsInt() : 0;

        // return assignments.stream().mapToInt(Assignment::getScore).min().getAsInt();
        // Tried to figure out how to work with Optional because line above gives a warning about using Optional without checking isPresent

//        Optional<Integer> low = assignments.stream().mapToInt(Assignment::getScore).min();
//        OptionalInt lowScore = assignments.stream().mapToInt(Assignment::getScore).min();
//        return lowScore.isPresent() ? lowScore.getAsInt() : 0;
//        return lowScore.ifPresentOrElse();
//        return lowScore.orElse(0);
    }


    public int getHighScore() {
        return assignments.stream().mapToInt(Assignment::getScore).max().getAsInt();
    }


    public double getAverageScore() {
        return assignments.stream().mapToInt(Assignment::getScore).average().getAsDouble();
    }

}
