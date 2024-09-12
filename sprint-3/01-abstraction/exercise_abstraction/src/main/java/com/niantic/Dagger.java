package com.niantic;

public class Dagger extends Weapon {
    private int daggerCount;

    public Dagger(String name, int damage) {
        super(name, damage);
        daggerCount = 1;
    }

    public int getDaggerCount() {
        return daggerCount;
    }

    @Override
    public int attack() {
        // If there are daggers in the bag the attack delivers the default damage to the other character
        if (daggerCount == 0) {
            return 0;
        }

        // With a regular attack, daggers are always retrieved - so the count does not go down
        // Each throw charges the percentCharged by 20%
        int percentCharged = getPercentCharged();
        percentCharged += 20;
        // the Percent charged cannot exceed 100%
        if (percentCharged > 100) {
            percentCharged = 100;
        }
        setPercentCharged(percentCharged);

        return getDamage();
    }

    @Override
    public int powerAttack() {
        if (daggerCount == 0) {
            return 0;
        }

        int percentCharged = getPercentCharged();

        // can only be used if the dagger is charged 100%
        if (percentCharged < 100) {
            return attack();
        }

        // A dagger cannot be retrieved from a power attack, so the daggerCount is reduced by 1
        daggerCount--;
        setPercentCharged(0);

        // 3x the default
        return 3 * getDamage();
    }

    @Override
    public int getRange() {
        return 10;
    }

    public void addDagger() {
        daggerCount++;
    }
}
