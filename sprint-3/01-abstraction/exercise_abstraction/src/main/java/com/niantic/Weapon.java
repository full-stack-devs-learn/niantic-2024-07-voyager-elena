package com.niantic;

public abstract class Weapon {
    protected String name;
    protected int damage;
    protected int percentCharged;
    protected int range;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        percentCharged = 0;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPercentCharged() {
        return percentCharged;
    }

    public abstract int getRange();

    protected abstract void setPercentCharged();

    public abstract int attack();

    public abstract int powerAttack();
}
