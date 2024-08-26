package com.niantic.models;

import com.niantic.models.enums.FaceValue;
import com.niantic.models.enums.Suit;
import com.niantic.ui.ColorCodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card;
    private Suit hearts = Suit.HEARTS;
    private FaceValue queen = FaceValue.QUEEN;

    @BeforeEach
    public void setup() {
        card = new Card(hearts, queen);
    }

    @Test
    public void card_parameterizedConstructor_ShouldCreateCardWithGivenParameters() {
        // arrange
        // act
        Suit expectedSuit = hearts;
        // to test if the test fails :)
        // Suit expectedSuit = Suit.SPADES;
        FaceValue expectedFaceValue = queen;

        // assert
        assertNotNull(card, "Card object should be created");
        Suit actualSuit = card.getSuit();
        FaceValue actualFaceValue = card.getFaceValue();
        assertEquals(expectedSuit, actualSuit, "The card should have Suit set in the constructor - Hearts");
        assertEquals(expectedFaceValue, actualFaceValue, "The card should have FaceValue set in the constructor");
    }

    @Test
    void testToString_shouldReturn_CorrectCardStringRepresentation() {
        // arrange

        // act
        String actualString = card.toString();
        String expectedString = ColorCodes.WHITE_BACKGROUND + queen.getDisplayValue() + hearts.getImage() + ColorCodes.RESET;

        // assert
        assertEquals(expectedString, actualString, "Card's ToString() should return face displayValue and image for suit on white background");
    }

    @Test
    void compareTo_shouldReturnNegativeValue_whenParameterHasGreaterFaceValue() {
        // arrange
        Card card2 = new Card(Suit.DIAMONDS, FaceValue.ACE);

        // set
        int actualresultSign = card.compareTo(card2) == 0 ? 0 : card.compareTo(card2) / Math.abs(card.compareTo(card2));
        int expectedResultSign = -1;

        // assert
        assertEquals(expectedResultSign, actualresultSign, "card.CompareTo(card2) should be negative if card's faceValue less than card2's face value");
    }

    @Test
    void compareTo_shouldReturnPositiveValue_whenParameterHasLesserFaceValue() {
        // arrange
        Card card2 = new Card(Suit.DIAMONDS, FaceValue.FIVE);

        // set
        int actualresultSign = card.compareTo(card2) == 0 ? 0 : card.compareTo(card2) / Math.abs(card.compareTo(card2));
        int expectedResultSign = 1;

        // assert
        assertEquals(expectedResultSign, actualresultSign, "card.CompareTo(card2) should be positive if card's faceValue greater than card2's face value");
    }

    @Test
    void compareTo_shouldReturnZero_whenParameterEqualsToCard() {
        // arrange
        Card card2 = new Card(hearts, queen);

        // set
        int actualresultSign = card.compareTo(card2) == 0 ? 0 : card.compareTo(card2) / Math.abs(card.compareTo(card2));
        int expectedResultSign = 0;

        // assert
        assertEquals(expectedResultSign, actualresultSign, "card.CompareTo(card2) should be 0 if cards equal");
    }
}