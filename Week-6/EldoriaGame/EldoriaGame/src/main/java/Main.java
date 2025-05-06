public class Main {

    public static void main(String[] args) {
        System.out.println("Eldoria Game Demo");

        Hero aragorn = new Hero("Aragorn",10);
        Enemy orc = new Enemy("Orc Captain",8);

        System.out.println("Characters speaks.");
        System.out.println(aragorn.speak());
        System.out.println(orc.speak());




        QuestBoard questBoard = new QuestBoard();

        if (aragorn instanceof Questable) {
            questBoard.assignQuest((Questable) aragorn,"Defeat the Goblin");

        }else {
            System.out.println(aragorn.getName()+ "cannot accept.");
        }

        BattleManager.startBattle(aragorn,orc);
        System.out.println("Game End");
    }
}
