package org.example;

public abstract class Character {

    protected String name;

    protected int health;

    protected int attackPower;

    /**
     * Creates a new character.
     * @param name
     * @param health
     * @param attackPower
     */
    public Character (String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;

    }

    /**
     * Gets character name.
     * @return Character name
     */
    public String getName() {
        if (name != null) {
            return name;
        }
        return "Unknown";

    }

    /**
     * Gets current health points.
     * @return health.
     */
    public int getHealth(){
        return health;

    }

    /**
     * Reduces character health by damage amount.
     * @param damage to taken.
     */
    public void takeDamage(int damage) {

        health -= damage;

    }


    /**
     * Performs character's special attack.
     * @param opponent Target character
     */

    public abstract void special_Attack(Character opponent);

    /**
     * Checks if character is defeated.
     * @return true if health is 0.
     */
    public boolean isDefeated() {
        if (health <= 0) return true;
        return false;

    }

    /**
     * Defends against incoming damage.
     * @param damage Amount
     * @return damage reduced
     */
    public int defend(int damage) {
        int reduction = damage / 4;
        return Math.max(1, damage - reduction);
    }

    public void complexMethodExample() {

    }
}
