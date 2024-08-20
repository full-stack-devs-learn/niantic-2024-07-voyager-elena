package com.niantic.part_1;

public class Quiz {
    private int score;
    private final int possiblePoints;
    private final String studentName;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPossiblePoints() {
        return possiblePoints;
    }

    public String getStudentName() {
        return studentName;
    }

    public Quiz(int possiblePoints, String studentName) {
        this.possiblePoints = possiblePoints;
        this.studentName = studentName;
    }

    public int getPercent() {
        return score * 100 / possiblePoints;
    }

    public String getLetterGrade() {
        int percent = getPercent();

        // added these two line to test tests :)
        // if (percent == 39) return "ABC";
        // if (percent == 0) return "XYZ";


        if (percent >= 90) return "A";
        else if (percent >= 80) return "B";
        else if (percent >= 70) return "C";
        else if (percent >= 60) return "D";
        else return "F";
    }
}
