package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameSmokeTest {

    @Test
    public void testCharacterCreation() {
        Warrior warrior = new Warrior("Arthur", 100, 15);
        assertEquals("Arthur", warrior.getName());
        assertEquals(100, warrior.getHealth());

    }

    @Test
    public void testGameSetup () {
        Game game = new Game();
        game.addCharacter(new Warrior("Arthur", 100, 15));
        game.addCharacter(new Mage("Merlin", 80, 20));
    }

    @Test
    public void testBasicAttack() {
        Warrior attacker = new Warrior("Arthur", 100, 15);
        Mage defender = new Mage("Merlin", 80, 20);
        int initialHealth = defender.getHealth();
        attacker.special_Attack(defender);
        assertTrue(defender.getHealth() < initialHealth);

    }

    @Test
    public void testDefeatCondition () {
        Character character = new Warrior("Arthur", 50, 10);
        character.takeDamage(60);
        assertTrue(character.isDefeated());

    }

    @Test
    public void testBoostAbility() {
        Warrior warrior = new Warrior("Arthur", 100, 15);
        int normalAttack = warrior.getHealth();
        int boostedAttack = warrior.boost();
        assertTrue(boostedAttack >= normalAttack);

    }

} 