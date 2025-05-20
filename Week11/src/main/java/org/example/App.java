package org.example;

public class App 
{
    public static void main(String[] args) {
        // Create characters
        Character frodo = new Character("Frodo", "Hobbit", 50, "Ring Bearer");
        Character aragorn = new Character("Aragorn", "Human", 87, "King");

        // Print character details
        frodo.printDetails();
        aragorn.printDetails();

        // Create locations
        Location shire = new Location("Shire", false);
        Location mordor = new Location("Mordor", true);
        shire.addConnectedLocation("Mordor");

        // Create quests
        Quest destroyRing = new Quest("Destroy the Ring", "Main Quest", 10, 1000);
        Quest defendShire = new Quest("Defend the Shire", "Side Quest", 3, 200);

        // Character join a quest
        destroyRing.addParticipant(frodo);
        System.out.println(frodo.getName() + " joined the quest: " + destroyRing.getName());

        // Quest participants.
        for (Character c : destroyRing.getParticipants()) {
            System.out.println("Participant: " + c.getName());
        }
        // Simple location navigation example.
        System.out.println("Is Shire connected to Mordor? " + shire.isConnectedTo("Mordor"));
    }
}
