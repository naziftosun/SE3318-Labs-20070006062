package org.example;

import java.util.ArrayList;
import java.util.List;

public class Adventurer extends Character implements Joinable{

    private String race;
    private List<Quest> undertakenQuests;

    public Adventurer(String name, String title,String race) {
        super(name, title);
        this.race = race;
        this.undertakenQuests = new ArrayList<>();
    }

    @Override
    public void joinQuest(Quest questObject) {
        if (questObject instanceof Quest){
            Quest quest = (Quest) questObject;
            if (!this.undertakenQuests.contains(quest)){
                this.undertakenQuests.add(quest);
                quest.addAdventurer(this);
                System.out.println(getName() + "has joined the quest:"+ quest.getName());

            }else {
                System.out.println(getName() +"is already on the quest:"+ quest.getName());

            }
        }else {
            System.out.println("Invalid object");
        }

    }

    public void listUndertakenQuests(){
        System.out.println(getName() + "(" + race+ ") has undertaken quests:");
        if (undertakenQuests.isEmpty()){
            System.out.println("there is not yet.");
        }else {
            for (Quest quest : undertakenQuests){
                System.out.println(" - "+quest.getName());
            }
        }
    }

    public String getRace(){
        return race;
    }

    public List<Quest> getUndertakenQuests(){
        return undertakenQuests;
    }

}
