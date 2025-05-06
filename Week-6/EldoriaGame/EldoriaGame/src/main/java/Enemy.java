public class Enemy extends Character{
    public Enemy(String name, int level) {
        super(name, level);
    }

    @Override
    public String speak() {
        return "I am lord of the shadows " + this.getName() + "You are done.My level is " + this.getLevel() + ".";

    }
}
