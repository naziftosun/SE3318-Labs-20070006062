public abstract class Character {

    private String name;
    private int level;

    public Character(String name,int level) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Character name cannot be null or empty.");
        }
        if (level <= 0){
            throw new IllegalArgumentException("Character level must be positive.");

        }
        this.name = name;
        this.level = level;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level) {
        if (level <= 0) {
            throw new IllegalArgumentException("Character level must be positive.");

        }
        this.level = level;
    }

    public abstract String speak();

}
