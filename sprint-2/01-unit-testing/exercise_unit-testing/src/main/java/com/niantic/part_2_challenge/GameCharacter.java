package com.niantic.part_2_challenge;

public class GameCharacter
{
    private final String name;
    private final int maxEnergyLevel;
    private int energyLevel;

    public String getName()
    {
        return name;
    }

    public int getEnergyLevel()
    {
        return energyLevel;
    }

    public int getMaxEnergyLevel()
    {
        return maxEnergyLevel;
    }

    public GameCharacter(int maxEnergyLevel, String name)
    {
        this.maxEnergyLevel = maxEnergyLevel;
        this.name = name;

        // I believe we should set initial value of energyLevel to maxEnergyLevel
        // otherwise it is impossible to do something with the gameCharacter object,
        // we cannot heal the character with energyLevel = 0
        // because of this requirement "If the energyLevel reaches 0 the character is knocked out and cannot heal anymore."

        this.energyLevel = maxEnergyLevel;
        // this.energyLevel = 0;

    }

    public void takeHit(int damage)
    {
        if (damage <= energyLevel) {
            energyLevel -= damage;
        } else {
            energyLevel = 0;
        }
    }

    public void heal(int amount)
    {
        if (isKnockedOut()) {
            // can not heal
            return;
        }
        energyLevel += amount;
        if (energyLevel > maxEnergyLevel) {
            energyLevel = maxEnergyLevel;
        }
    }

    public boolean isKnockedOut()
    {
        return energyLevel == 0;
    }
}
