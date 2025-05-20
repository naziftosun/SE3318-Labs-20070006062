package org.example;

/**
 * Represents a character from The Lord of the Rings universe.
 */
public class Character {
    /**
     * Character name.
     */
    private String name;
    /**
     * Character race.
     */
    private String race;
    /**
     * Character age.
     */
    private int age;
    /**
     * Character's special attribute (weapon or title).
     */
    private String specialAttribute;

    /**
     * Creates a new character.
     * @param name character's name
     * @param race character's race
     * @param age character's age
     * @param specialAttribute character's special attribute
     */
    public Character(String name, String race, int age, String specialAttribute) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.specialAttribute = specialAttribute;
    }

    // Getters and setters
    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace () {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge (int age) {
        this.age = age;

    }

    public String getSpecialAttribute() {
        return specialAttribute;

    }

    public void setSpecialAttribute(String specialAttribute) {
        this.specialAttribute = specialAttribute;
    }

    public void printDetails() {
        if (race.equals("Hobbit"))
            System.out.println("Character is a Hobbit");
         else


        if (age >= 50) {
            System.out.println("Character is 50 or older");
        } else if (name.equals("Frodo"))
            System.out.println("Character is Frodo");
    }
}