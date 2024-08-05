package com.niantic.part_3_challenge;

public class Refrigerator {
    private final int CURRENT_TEMPERATURE;
    private final int MAX_CAPACITY;
    private int capacityAvailable;
    private boolean isDoorOpen;

    public Refrigerator(int currentTemperature, int maxCapacity) {
        this.CURRENT_TEMPERATURE = currentTemperature;
        this.MAX_CAPACITY = maxCapacity;
        capacityAvailable = MAX_CAPACITY;
    }

    public int getCurrentTemperature() {
        return CURRENT_TEMPERATURE;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getAvailableCapacity() {
        return capacityAvailable;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void openDoor() {
        isDoorOpen = true;
    }

    public void closeDoor() {
        isDoorOpen = false;
    }

    public boolean addItem(int capacity) {
        if (isDoorOpen && capacityAvailable >= capacity) {
            capacityAvailable -= capacity;
            return true;
        }
        return false;
    }

    public boolean removeItem(int capacity) {
        if (isDoorOpen && capacity <= capacityAvailable) {
            capacityAvailable += capacity;
            return true;
        }
        return false;
    }
}
