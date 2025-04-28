package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends Character{
    private List<Quest> overseenQuests;

    public Mentor(String name, String title) {
        super(name, title);
        this.overseenQuests = new ArrayList<>();
    }

    public void assignQuest(Quest quest){
        this.overseenQuests.add(quest);
    }

    public void listOverseenQuests(){
        System.out.println(getName()+" "+getTitle() + " oversees the following quests:");
        if (overseenQuests.isEmpty()){
            System.out.println(" there is not yet.");
        }else {
            for (Quest quest : overseenQuests ){
                System.out.println(" - "+ quest.getName());
            }
        }
    }
    public List<Quest> getOverseenQuests(){
        return overseenQuests;
    }
}
