package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> filteredTestScores = new ArrayList<>();

        for (var testScore : testScores) {
            if (testScore.getTestName().equals(testName)) {
                filteredTestScores.add(testScore);
            }
        }

        return filteredTestScores;
    }

    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student) {
        ArrayList<TestScore> filteredTestScores = new ArrayList<>();

        for (var testScore : testScores) {
            if (testScore.getStudentName().equals(student)) {
                filteredTestScores.add(testScore);
            }
        }

        return filteredTestScores;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores) {
        int highestScore = 0; // I believe that test scores cannot be negative

        for (var testScore : testScores) {
            highestScore = Math.max(highestScore, testScore.getScore());
        }

        return highestScore;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores) {
        int lowestScore = testScores.getFirst().getScore();

        // which way is more correct? get first value from list or initialize with max value possible?
        // int lowestScore = Integer.MAX_VALUE;

        for (var testScore : testScores) {
            lowestScore = Math.min(lowestScore, testScore.getScore());
        }

        return lowestScore;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores) {
        int average = 0; // int???

        for (var testScore : testScores) {
            average += testScore.getScore();
        }
        average /= testScores.size();

        return average;
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName) {
        // the easiest way to do it is to use functions we already have
        // but maybe it is not the most efficient way because we loop twice,
        // anyway it is O(n), where n = testScores.size()

        // return getHighestScore(getScoresByTest(testScores, testName));

        // another way to solve it with one loop
        int highestScore = 0;

        for (var testScore : testScores) {
            if (testScore.getTestName().equals(testName)) {
                highestScore = Math.max(highestScore, testScore.getScore());
            }
        }

        return highestScore;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName) {
        return getLowestScore(getScoresByTest(testScores, testName));
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName) {
        return getAverageScore(getScoresByTest(testScores, testName));
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student) {
        return getHighestScore(getScoresByStudent(testScores, student));
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student) {
        return getLowestScore(getScoresByStudent(testScores, student));
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student) {
        return getAverageScore(getScoresByStudent(testScores, student));
    }
}
