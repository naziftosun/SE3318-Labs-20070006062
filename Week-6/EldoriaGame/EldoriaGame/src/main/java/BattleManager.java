public class BattleManager {

    private BattleManager(){

    }

    public static void startBattle(Hero hero, Enemy enemy){
        if(hero == null || enemy == null){
            System.out.println("Battle can not start: Hero and Enemey should be provided.");
            return;
        }
        System.out.println("Battle:" + hero.getName() + " vs " + enemy.getName());

        if (hero.getLevel() >= enemy.getLevel() ) {
            System.out.println("Hero defeats and wins.");
        }else {
            System.out.println("Enemy won.");
        }

        System.out.println("Battle finished");
    }
}
