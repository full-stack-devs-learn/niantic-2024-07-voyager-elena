package com.niantic.models.enums;


public enum FaceValue {

    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11,"J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");


    private final int intValue;
    private final String displayValue;

    FaceValue(int value, String displayValue) {
        this.intValue = value;
        this.displayValue = displayValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}

