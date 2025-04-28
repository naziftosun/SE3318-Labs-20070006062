package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Quest Management System");

        Mentor gandalf = new Mentor("Gandalf", "the Grey");
        Mentor elrond = new Mentor("Elrond", "Half-elven");

        Quest destroyRing = new Quest("Destroy the One Ring", 10, gandalf);
        Quest defendHelmsDeep = new Quest("Defend Helm's Deep", 8, gandalf);
        Quest counselElrond = new Quest("Join the Council of Elrond", 5, elrond);

        gandalf.assignQuest(destroyRing);
        gandalf.assignQuest(defendHelmsDeep);
        elrond.assignQuest(counselElrond);

        Adventurer frodo = new Adventurer("Frodo", "Ringbearer", "Hobbit");
        Adventurer aragorn = new Adventurer("Aragorn", "Heir of Gondor", "Man");
        Adventurer legolas = new Adventurer("Legolas", "Prince of Woodland Realm", "Elf");
        Adventurer gimli = new Adventurer("Gimli", "Dwarf of the Lonely Mountain", "Dwarf");

        System.out.println("\nAssigning Adventurers to Quests");
        frodo.joinQuest(destroyRing);
        aragorn.joinQuest(destroyRing);
        legolas.joinQuest(destroyRing);
        gimli.joinQuest(destroyRing);


        aragorn.joinQuest(defendHelmsDeep);
        legolas.joinQuest(defendHelmsDeep);
        gimli.joinQuest(defendHelmsDeep);

        frodo.joinQuest(counselElrond);
        aragorn.joinQuest(counselElrond);
        legolas.joinQuest(counselElrond);
        gimli.joinQuest(counselElrond);



        System.out.println("\nMentor Quest Overview");
        gandalf.listOverseenQuests();
        elrond.listOverseenQuests();

        System.out.println("\nAdventurer Quest Logs");
        frodo.listUndertakenQuests();
        aragorn.listUndertakenQuests();
        legolas.listUndertakenQuests();
        gimli.listUndertakenQuests();

        System.out.println("\nQuest Adventurer Lists");
        destroyRing.listAdventurers();
        defendHelmsDeep.listAdventurers();
        counselElrond.listAdventurers();

    }
}
