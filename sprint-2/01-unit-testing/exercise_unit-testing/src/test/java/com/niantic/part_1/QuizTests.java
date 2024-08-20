package com.niantic.part_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuizTests {
    private Quiz quiz;
    private final int possiblePoints = 100;
    private final String studentName = "John Doe";

    @BeforeEach
    public void setup() {
        quiz = new Quiz(possiblePoints, studentName);
    }

    @Test
    public void quiz_parameterizedConstructor_ShouldCreateQuizWithGivenPossiblePointsAndStudentName() {
        // arrange
        // act
        int actualPossiblePoints = quiz.getPossiblePoints();
        String actualStudentName = quiz.getStudentName();

        // assert
        assertNotNull(quiz, "Quiz object should be created");
        assertEquals(possiblePoints, actualPossiblePoints, "The quiz should have possibleScores set in the constructor");
        assertEquals(studentName, actualStudentName, "The quiz should have studentName set in the constructor");
    }

    @Test
    public void getPercent_shouldCalculatePercent() {
        // arrange
        int score = 76;
        int expectedPercent = score * 100 / possiblePoints;
        quiz.setScore(score);

        // act
        int actualPercent = quiz.getPercent();

        // assert
        assertEquals(expectedPercent, actualPercent, "Percentage for score = " + score + " should be equals to " + expectedPercent);
    }

    @Test
    public void getLetterGrade_shouldReturnA_whenPercentAbove90() {
        // arrange
        int score = 91;
        String expectedLetterGrade = "A";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnA_whenPercentIs90() {
        // arrange
        int score = 90;
        String expectedLetterGrade = "A";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnB_whenPercentBetween80and90() {
        // arrange
        int score = 87;
        String expectedLetterGrade = "B";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnB_whenPercentIs80() {
        // arrange
        int score = 80;
        String expectedLetterGrade = "B";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnC_whenPercentBetween70and80() {
        // arrange
        int score = 73;
        String expectedLetterGrade = "C";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnC_whenPercentIs70() {
        // arrange
        int score = 70;
        String expectedLetterGrade = "C";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnD_whenPercentBetween60and70() {
        // arrange
        int score = 68;
        String expectedLetterGrade = "D";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnD_whenPercentIs60() {
        // arrange
        int score = 60;
        String expectedLetterGrade = "D";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnF_whenPercentBetween50and60() {
        // arrange
        int score = 54;
        String expectedLetterGrade = "F";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnF_whenPercentIs50() {
        // arrange
        int score = 50;
        String expectedLetterGrade = "F";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnF_whenPercentBelow50() {
        // arrange
        int score = 34;
        String expectedLetterGrade = "F";
        quiz.setScore(score);

        // act
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade,
                "Letter grade for score = " + score +
                        " and possiblePoints = " + possiblePoints +
                        " should be equals to " + expectedLetterGrade);
    }

    @Test
    public void getLetterGrade_shouldReturnF_whenPercentBelow60() {
        // I want to test every case from 0 to 59
        // tests for A, B, C, D could be organized the same way, with for loop
        // for (int score = 90; score <= 100; score++) for A
        // for (int score = 80; score < 90 ; score++) for B
        // for (int score = 70; score < 80; score++) for C
        // for (int score = 60; score < 70; score++) for D


        // arrange
        String expectedLetterGrade = "F";

        for (int score = 0; score < 60; score++) {
            //arrange
            quiz.setScore(score);

            // act
            String actualLetterGrade = quiz.getLetterGrade();

            // assert
            assertEquals(expectedLetterGrade, actualLetterGrade,
                    "Letter grade for score = " + score +
                            " and possiblePoints = " + possiblePoints +
                            " should be equals to " + expectedLetterGrade);
        }
    }

}