package com.niantic.models;

public class Assignment implements Comparable<Assignment> {
    private int number;
    private Student student;
    private String assignmentName;
    private int score;

    public Assignment(int number, Student student, String assignmentName, int score) {
        this.number = number;
        this.student = student;
        this.assignmentName = assignmentName;
        this.score = score;
    }

    public Assignment() {
    }

    public int getNumber() {
        return number;
    }

    public Student getStudent() {
        return student;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%3d    %-31s %3d", number, assignmentName, score);
    }

    public String toStringWithStudent() {
        String studentFullName = student.getFirstName() + " " + student.getLastName();
        return String.format("%3d    %-30s %-18s %3d", number, assignmentName, studentFullName, score);
    }

    @Override
    public int compareTo(Assignment o) {
        return this.number - o.getNumber();
    }
}
