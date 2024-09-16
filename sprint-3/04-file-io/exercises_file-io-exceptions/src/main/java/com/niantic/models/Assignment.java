package com.niantic.models;

public class Assignment {
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

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%3d    %-30s %3d", number, assignmentName, score);
    }
}
