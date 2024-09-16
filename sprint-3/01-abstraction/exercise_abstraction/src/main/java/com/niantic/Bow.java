package com.niantic;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Bow extends Weapon {

    // possible options are: standard, poison, explosive
    // Arrow power:
    //      standard: default damage
    //      poison arrows: 2x damage
    //      explosive arrows: 3x damage
    private final Map<String, Integer> ARROW_TYPES_POWER = Map.of(
            "standard", 1,
            "poison", 2,
            "explosive", 3
    );
    private final Timer timer = new Timer();
    private final String arrowType;
    private final int quiverSize;
    private int arrowCount;
    private boolean hasPowerAttackStarted = false;


    public Bow(String name, int damage, String arrowType, int quiverSize) {
        super(name, damage);
        if (!ARROW_TYPES_POWER.containsKey(arrowType)) {
            throw new IllegalArgumentException("Invalid arrow type: " + arrowType);
        }
        this.arrowType = arrowType;
        this.quiverSize = quiverSize;
        arrowCount = quiverSize;

        // Arrows are replenished 1 at a time in 5 second intervals
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (arrowCount < quiverSize) {
                    arrowCount++;
                }
            }
        }, 0, 5000);

        // percentCharge increases by 20% every 2 seconds
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int percentCharged = getPercentCharged();
                percentCharged += 20;
                if (percentCharged > 100) {
                    percentCharged = 100;
                }
                setPercentCharged(percentCharged);
            }
        }, 0, 2000);
    }

    public String getArrowType() {
        return arrowType;
    }

    public int getQuiverSize() {
        return quiverSize;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    @Override
    public int attack() {
        if (arrowCount == 0) {
            return 0;
        }

        // Each attack shoots one arrow
        arrowCount--;

        return ARROW_TYPES_POWER.get(arrowType) * getDamage();
    }

    @Override
    public int powerAttack() {
        int percentCharged = getPercentCharged();

        if (percentCharged < 100) {
            return attack();
        }

        // When the bow is fully charged, you have 5 seconds of unlimited arrows (no arrows are lost)
        // And each arrow delivers double attack power
        if (!hasPowerAttackStarted) {
            hasPowerAttackStarted = true;

            // set hasPowerAttackStarted false and percentCharged to zero in 5 seconds
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    hasPowerAttackStarted = false;
                    setPercentCharged(0);
                }
            }, 5000);

        }

        return 2 * ARROW_TYPES_POWER.get(arrowType) * getDamage();
    }

    @Override
    public int getRange() {
        return 20;
    }
}
