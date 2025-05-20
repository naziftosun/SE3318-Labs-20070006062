package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a quest in Middle-Earth.
 */
public class Quest {
    /**
     * The name of the quest.
     */
    private String name;
    /**
     * The type of the quest.
     */
    private String type;
    /**
     * The difficulty level of the quest.
     */
    private int difficultyLevel;
    /**
     * The participants of the quest.
     */
    private List<Character> participants;
    /**
     * The reward points for the quest.
     */
    private int rewardPoints;

    /**
     * Creates a new quest.
     * @param name
     * @param type
     * @param difficultyLevel
     * @param rewardPoints
     */
    public Quest(String name, String type, int difficultyLevel, int rewardPoints) {
        this.name = name;
        this.type = type;
        this.difficultyLevel = difficultyLevel;
        this.rewardPoints = rewardPoints;
        this.participants = new ArrayList<>();
    }

    /**
     * Adds a participant to the quest.
     * @param character character to add
     */
    public void addParticipant(Character character) {
        participants.add(character);
    }

    /**
     * Removes a participant from the quest.
     * @param character
     */
    public void removeParticipant(Character character) {
        participants.remove(character);
    }

    /**
     * Checks if a character can participate in this quest based on their attributes.
     * @param character
     * @return true if character can participate
     */
    public boolean canParticipate(Character character) {
        // Basic check: character must be at least 18 years old for difficult quests
        return character.getAge() >= 18 || difficultyLevel < 5;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDifficultyLevel () {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Character> getParticipants() {
        return participants;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints (int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}