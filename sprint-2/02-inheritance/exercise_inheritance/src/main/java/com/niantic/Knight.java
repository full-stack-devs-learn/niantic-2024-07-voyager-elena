package com.niantic;

public class Knight extends Character {

    private int armor;

    public Knight(String name, int health, int level, int experience, int armor) {
        super(name, health, level, experience);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void takeDamage(int damage) {
        // The armor should deflect the amount of damage that the armor can handle
        // If the armor is more powerful than the attack, then no damage is sustained by the knight
        // Any additional damage should be removed from the health of the knight.
        if (armor > 0) {
            System.out.println("The damage was decreased because " + name + " has special ability: " + specialAbility() + " and the armor = " + armor);
            damage -= armor;
            if (damage < 0) {
                damage = 0;
            }
        }
        super.takeDamage(damage);

        // The armor's level does not decrease, but can be re-used
        // so no need to change armor
    }

    @Override
    public void levelUp() {
        // should perform all of the levelUp functions of a character levelUp()
        super.levelUp();
        // should also increase the armor by 5 points
        armor += 5;
    }

    @Override
    public String specialAbility() {
        return "Armor Shield";
    }
}
