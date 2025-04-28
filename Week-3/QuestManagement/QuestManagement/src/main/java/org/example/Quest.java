package org.example;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    private String name;
    private int difficultyLevel;
    private Mentor mentor;
    private List<Adventurer> adventurers;

    public Quest(String name,int difficultyLevel,Mentor mentor){
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.mentor = mentor;
        this.adventurers = new ArrayList<>();
    }


    public void addAdventurer(Adventurer adventurer) {
        this.adventurers.add(adventurer);
    }

    public void listAdventurers() {
        System.out.println("Adventurers in quest '" + name + "':");
        if (adventurers.isEmpty()) {
            System.out.println("  None yet.");
        } else {
            for (Adventurer adventurer : adventurers) {
                System.out.println("  - " + adventurer.getName() + " (" + adventurer.getRace() + ")");
            }
        }
    }
    public String getName() {
        return name;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }
}
