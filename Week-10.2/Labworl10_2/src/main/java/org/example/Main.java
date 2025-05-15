package org.example;

public class Main {

    /**
     * Main method
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.addCharacter(new Warrior("Conan", 100, 15));
        game.addCharacter(new Mage("Merlin", 80, 20));
        game.addCharacter(new Archer("Legolas", 90, 18));

        game.StartGame();

    }

}