import java.util.ArrayList;
import java.util.List;

public class QuestBoard {

    private List<String> quests;


    public QuestBoard() {
        this.quests = new ArrayList<>();
        this.quests.add("Defeat goblins.");
        this.quests.add("Defeat monster.");
    }

    public void displayAvailableQuests(){
        System.out.println("Available quests on board.");
        if (this.quests.isEmpty()) {
            System.out.println("No available quests.");
            return;
        }
        for (int i = 0; i < this.quests.size();i++) {
            System.out.println((i+1) +" " + this.quests.get(i));
        }
    }

    public boolean assignQuest(Questable character, String questName){
        if (character == null){
            System.out.println("Character can not be null.");
            return false;
        }
        if (questName == null || questName.trim().isEmpty()) {
            System.out.println("Quest name can not be null");
            return false;
        }

        if (this.quests.contains(questName)) {
            character.accepQuest(questName);

            System.out.println("Quest " + questName + "assigned.");
            return true;
        }else {
            System.out.println("quest"+ questName +" is not available.");
            return false;
        }

    }


}
