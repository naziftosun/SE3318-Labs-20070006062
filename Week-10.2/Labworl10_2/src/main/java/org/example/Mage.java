package org.example;

public class Mage extends Character {


    private int manaPoints;

    /**
     * Creates a new mage.
     * @param name
     * @param health
     * @param attackPower
     */
    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
        this.manaPoints = 100;
    }

    @Override
    public void special_Attack(Character Opponent) {
        if (manaPoints >= 20) {
            Opponent.takeDamage(attackPower + 50);
            manaPoints -= 20;
        } else {
            Opponent.takeDamage(attackPower);

        }

    }

    /**
     * Boosts mage's attack power using mana.
     * @return attack power
     */
    public int boost() {
        if (manaPoints >= 30) {
            manaPoints -= 30;
            return attackPower * 2;

        }
        return attackPower;

    }

    @Override
    public int defend(int damage) {
        // Mages use mana shield to defend
        if (manaPoints >= 10) {
            manaPoints -= 10;
            return damage / 2;
        }
        return damage;
    }

}
