package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests {

    @Test
    public void rectangle_parameterlessConstructor_ShouldCreateSquareOfSize5x5() {
        // arrange
        int expectedWidth = 5;
        int expectedHeight = 5;

        // act
        Rectangle rectangle = new Rectangle();

        // assert
        assertNotNull(rectangle, "Rectangle object should be created");
        assertEquals(expectedWidth, rectangle.getWidth(), "The rectangle width should be equal to " + expectedWidth);
        assertEquals(expectedHeight, rectangle.getHeight(), "The rectangle height should be equal to " + expectedHeight);
    }

    @Test
    public void rectangle_parameterizedConstructor_ShouldCreateRectangleOfGivenSizes() {
        // arrange
        int expectedWidth = 7;
        int expectedHeight = 19;

        // act
        Rectangle rectangle = new Rectangle(expectedWidth, expectedHeight);

        // assert
        assertNotNull(rectangle, "Rectangle object should be created");
        assertEquals(expectedWidth, rectangle.getWidth(), "The rectangle width should be equal to " + expectedWidth);
        assertEquals(expectedHeight, rectangle.getHeight(), "The rectangle height should be equal to " + expectedHeight);
    }

    @Test
    public void getArea_shouldReturnCorrectArea_whenSizesArePositive() {
        // arrange
        int width = 7;
        int height = 11;
        int expectedArea = width * height;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualArea = rectangle.getArea();

        // assert
        assertEquals(expectedArea, actualArea,
                "getArea should return " + expectedArea +
                        " when width is " + width +
                        " and height is " + height);
    }

    @Test
    public void getArea_shouldReturnZero_whenWidthIsZero() {
        // arrange
        int width = 0;
        int height = 15;
        int expectedArea = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualArea = rectangle.getArea();

        // assert
        assertEquals(expectedArea, actualArea, "getArea should return 0 when width is zero");
    }

    @Test
    public void getArea_shouldReturnZero_whenHeightIsZero() {
        // arrange
        int width = 7;
        int height = 0;
        int expectedArea = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualArea = rectangle.getArea();

        // assert
        assertEquals(expectedArea, actualArea, "getArea should return 0 when height is zero");
    }


    @Test
    public void getArea_shouldReturnZero_withNegativeWidth() {
        // arrange
        int width = -7;
        int height = 15;
        int expectedArea = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualArea = rectangle.getArea();

        // assert
        assertEquals(expectedArea, actualArea, "getArea should return 0 when width is negative");
    }

    @Test
    public void getArea_shouldReturnZero_withNegativeHeight() {
        // arrange
        int width = 7;
        int height = -11;
        int expectedArea = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualArea = rectangle.getArea();

        // assert
        assertEquals(expectedArea, actualArea, "getArea should return 0 when height is negative");
    }

    @Test
    public void getPerimeter_shouldReturnCorrectPerimeter_whenSizesArePositive() {
        // arrange
        int width = 7;
        int height = 11;
        int expectedPerimeter = 2 * (width + height);
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualPerimeter = rectangle.getPerimeter();

        // assert
        assertEquals(expectedPerimeter, actualPerimeter,
                "getPerimeter should return " + expectedPerimeter +
                        " when width is " + width +
                        " and height is " + height);
    }

    @Test
    public void getPerimeter_shouldReturnZero_whenWidthIsZero() {
        // arrange
        int width = 0;
        int height = 15;
        int expectedPerimeter = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualPerimeter = rectangle.getPerimeter();

        // assert
        assertEquals(expectedPerimeter, actualPerimeter, "getPerimeter should return 0 when width is zero");
    }

    @Test
    public void getPerimeter_shouldReturnZero_whenHeightIsZero() {
        // arrange
        int width = 7;
        int height = 0;
        int expectedPerimeter = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualPerimeter = rectangle.getPerimeter();

        // assert
        assertEquals(expectedPerimeter, actualPerimeter, "getPerimeter should return 0 when height is zero");
    }


    @Test
    public void getPerimeter_shouldReturnZero_withNegativeWidth() {
        // arrange
        int width = -7;
        int height = 15;
        int expectedPerimeter = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualPerimeter = rectangle.getPerimeter();

        // assert
        assertEquals(expectedPerimeter, actualPerimeter, "getPerimeter should return 0 when width is negative");
    }

    @Test
    public void getPerimeter_shouldReturnZero_withNegativeHeight() {
        // arrange
        int width = 7;
        int height = -11;
        int expectedPerimeter = 0;
        Rectangle rectangle = new Rectangle(width, height);

        // act
        int actualPerimeter = rectangle.getPerimeter();

        // assert
        assertEquals(expectedPerimeter, actualPerimeter, "getPerimeter should return 0 when height is negative");
    }

}