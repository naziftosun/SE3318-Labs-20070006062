package org.example;

public class Archer extends Character {
    private int arrows;

    /**
     * Creates a new archer.
     * @param name
     * @param health
     * @param attackPower
     */
    public Archer(String name, int health, int attackPower) {

        super(name, health, attackPower);
        this.arrows = 20;

    }

    @Override
    public void special_Attack(Character opponent) {
        if (arrows >= 2) {
            opponent.takeDamage(attackPower + 20);
            arrows -= 2;
        } else {
            opponent.takeDamage(attackPower);

        }

    }

    /**
     * Boosts archer's attack power using precise aim.
     * @return Amount of attack.
     */
    public int boost() {

        if (arrows >= 3) {
            arrows -= 3;
            return attackPower + 15;
        }
        return attackPower;

    }

    @Override
    public int defend(int damage) {
        if (arrows >= 1) {
            arrows -= 1;
            return damage * 2 / 3;  // Takes only 2/3 of damage
        }
        return damage;

    }

}