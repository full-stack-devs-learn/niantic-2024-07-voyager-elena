package com.niantic.part_2_objects;

public class MathTest {

    private final int POSSIBLE_POINTS;
    private final String STUDENT_NAME;
    private int score;


    public MathTest(int possiblePoints, String studentName) {
        this.POSSIBLE_POINTS = possiblePoints;
        this.STUDENT_NAME = studentName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getPossiblePoints() {
        return POSSIBLE_POINTS;
    }

    public String getStudentName() {
        return STUDENT_NAME;
    }

    public String getLetterGrade() {
        int percent = getPercent();

        if (percent >= 90) {
            return "A";
        }
        if (percent >= 80) {
            return "B";
        }
        if (percent >= 70) {
            return "C";
        }
        if (percent >= 60) {
            return "D";
        }
        return "F";
    }

    public int getPercent() {
        return (int) Math.round(score * 100.00 / POSSIBLE_POINTS);
    }

}
