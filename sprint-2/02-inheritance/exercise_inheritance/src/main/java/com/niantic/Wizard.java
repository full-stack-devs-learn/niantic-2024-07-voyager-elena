package com.niantic;

public class Wizard extends Character {
    // castSpell() is a powerful attack that causes 2 times the damage of a normal attack
    private final int NUMBER_OF_ATTACKS_PER_SPELL = 2;
    private int mana;

    public Wizard(String name, int health, int level, int experience, int mana) {
        super(name, health, level, experience);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void castSpell(Character target) {
        // A wizard can only use a spell if they have at least 10 mana points
        if (getMana() < 10) {
            return;
        }

        // had to rewrite this part because this logic doesn't work when attacking a knight

        // for (int attackNum = 0; attackNum < NUMBER_OF_ATTACKS_PER_SPELL; attackNum++) {
        //     super.attack(target);
        // }

        // A wizard that has been defeated cannot cast spells
        if (isDefeated()) {
            System.out.println(this.name + " has been defeated and cannot " + specialAbility().toLowerCase());
            return;
        }

        System.out.println(this.name + " " + specialAbility().toLowerCase() + " on " + target.getName());
        target.takeDamage(attackDamage * NUMBER_OF_ATTACKS_PER_SPELL);

        // Each time the wizard casts a spell their mana is decreased by 10 points
        mana -= 10;
    }

    public void regenerateMana(int amount) {
        //  A wizard's mana can only increase if they have not been defeated
        if (!isDefeated()) {
            mana += amount;
        }
    }

    @Override
    public void levelUp() {
        // perform all of the levelUp functions of a character levelUp()
        // should also increase the mana by 10 points
        super.levelUp();
        if (!isDefeated()) {
            mana += 10;
        }
    }

    @Override
    public String specialAbility() {
        // return "Grow long white beard";
        return "Cast Spells";
    }
}
