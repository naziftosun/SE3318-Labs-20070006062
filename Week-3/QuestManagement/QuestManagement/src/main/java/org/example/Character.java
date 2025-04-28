package org.example;

public class Character {
    private String name;
    private String title;

    public Character(String name,String title){
        this.name = name;
        this.title = title;
    }
    public String getName(){
        return name;
    }
    public String getTitle(){
        return title;
    }
}
