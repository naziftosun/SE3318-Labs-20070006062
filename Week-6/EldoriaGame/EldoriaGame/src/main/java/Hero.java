public class Hero extends Character{


    public Hero(String name, int level) {
        super(name, level);
    }

    @Override
    public String speak() {
        return "For glory! My name is " + this.getName() + "and ı am level " + this.getLevel() + ".";
    }
}
