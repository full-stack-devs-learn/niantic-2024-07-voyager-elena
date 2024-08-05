package com.niantic.part_3_challenge;

public class Hotel {

    private final int NUMBER_OF_ROOMS;
    private final int NUMBER_OF_SUITES;
    private int bookedRooms;
    private int bookedSuites;
    private int availableRooms;
    private int availableSuites;

    public Hotel(int numberOfRooms, int numberOfSuites) {
        NUMBER_OF_ROOMS = numberOfRooms;
        NUMBER_OF_SUITES = numberOfSuites;
        availableRooms = NUMBER_OF_ROOMS;
        availableSuites = NUMBER_OF_SUITES;
    }

    public Hotel(int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites) {
        this(numberOfRooms, numberOfSuites);
        this.bookedRooms = bookedRooms;
        this.bookedSuites = bookedSuites;
        availableRooms -= bookedRooms;
        availableSuites -= bookedSuites;
    }

    public int getNumberOfRooms() {
        return NUMBER_OF_ROOMS;
    }

    public int getNumberOfSuites() {
        return NUMBER_OF_SUITES;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public int getAvailableSuites() {
        return availableSuites;
    }

    public boolean makeReservation(int numberOfRoomsToReserve, boolean isSuite) {
        if (isSuite) {
            if (availableSuites >= numberOfRoomsToReserve) {
                availableSuites -= numberOfRoomsToReserve;
                return true;
            }
            return false;
        }
        if (availableRooms >= numberOfRoomsToReserve) {
            availableRooms -= numberOfRoomsToReserve;
            return true;
        }
        return false;
    }
}
