package org.example;

public class Warrior extends Character {
    private int ragePoints;

    /**
     * Creates a new warrior.
     * @param name
     * @param health
     * @param attackPower
     */
    public Warrior (String name, int health, int attackPower) {
        super(name, health, attackPower);
        this.ragePoints = 0;

    }

    @Override
    public void special_Attack(Character opponent) {
        opponent.takeDamage(attackPower * 2);
        ragePoints += 1;
    }

    /**
     * Boosts warrior's attack power.
     * @return Amount of attack.
     */
    public int boost() {
        if (ragePoints >= 2) {
            ragePoints -= 2;
            return attackPower + 5;
        }
        return attackPower;
    }

    @Override
    public int defend(int damage) {
        // Warriors are tough
        if (ragePoints >= 1) {
            ragePoints -= 1;
            return damage / 3;
        }
        return damage;

    }
}