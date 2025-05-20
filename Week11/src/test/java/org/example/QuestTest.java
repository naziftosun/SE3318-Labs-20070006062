package org.example;

import junit.framework.TestCase;

/**
 * Test class for Quest.
 */
public class QuestTest extends TestCase {
    /**
     * The quest to test.
     */
    private Quest quest;
    /**
     * The character to test with the quest.
     */
    private Character character;

    @Override
    protected void setUp() {
        quest = new Quest("Destroy the Ring", "Main Quest", 10, 1000);
        character = new Character("Frodo", "Hobbit", 50, "Ring Bearer");
    }

    public void testAddParticipant() {
        quest.addParticipant(character);
        assertTrue(quest.getParticipants().contains(character));
    }

    public void testRemoveParticipant() {
        quest.addParticipant(character);
        quest.removeParticipant(character);
        assertFalse(quest.getParticipants().contains(character));
    }

    public void testCanParticipate() {
        assertTrue(quest.canParticipate(character));
        Character youngCharacter = new Character("Pippin", "Hobbit", 15, "Friend");
        assertFalse(quest.canParticipate(youngCharacter));

        Quest easyQuest = new Quest("Easy Quest", "Side Quest", 3, 100);
        assertTrue(easyQuest.canParticipate(youngCharacter));
    }
} 