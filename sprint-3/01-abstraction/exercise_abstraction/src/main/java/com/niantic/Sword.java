package com.niantic;

public class Sword extends Weapon {

    public Sword(String name, int damage) {
        super(name, damage);
    }

    @Override
    public int getRange() {
        return 1;
    }

    @Override
    public int attack() {
        // Each attack adds 10% to the percentCharged
        int percentCharged = getPercentCharged();
        percentCharged += 10;

        // the Percent charged cannot exceed 100%
        if (percentCharged > 100) {
            percentCharged = 100;
        }
        setPercentCharged(percentCharged);

        // each attack delivers the default damage
        return getDamage();
    }

    @Override
    public int powerAttack() {
        int percentCharged = getPercentCharged();

        // if percentCharged < 50% just performs a regular attack
        if (percentCharged < 50) {
            return attack();
        }

        // 100% delivers a 4x blow to the other character and reduces the charge to 0
        if (percentCharged == 100) {
            setPercentCharged(0);
            return 4 * getDamage();
        }

        // 50% - 90% delivers a double blow to the other character and reduces the charge by 50%
        percentCharged -= 50;
        setPercentCharged(percentCharged);
        return 2 * getDamage();
    }
}
