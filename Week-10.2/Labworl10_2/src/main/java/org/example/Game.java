package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Character> characters = new ArrayList<>();

    /**
     * Adds character to game.
     * @param character
     */
    public void addCharacter(Character character) {
        characters.add(character);
    }

    /**
     * Starts the game.
     */
    public void StartGame() {
        int turn = 0;
        boolean gameOver = false;

        while (!gameOver) {
            Character attacker = characters.get(turn % characters.size());
            Character defender = characters.get((turn + 1) % characters.size());

            attacker.special_Attack(defender);
            System.out.println(attacker.getName() + " attacks " + defender.getName());

            if (defender.isDefeated()) {
                System.out.println(defender.getName() + " is defeated!");
                gameOver = true;
            }

            turn++;
        }
    }

    /**
     * Checks game over.
     * @return true if over
     */
    private boolean isGameOver() {
        for (Character character : characters) {
            if (character.isDefeated()) {
                return true;
            }
        }
        return false;
    }
}

