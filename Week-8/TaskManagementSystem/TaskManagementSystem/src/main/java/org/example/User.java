package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String userName;
    private String email;
    private List<Task> tasks;

    /**
     *Creates a new User with the given username and email.
     * requires: Username is not null, email is not null(ideally valid).
     * effects: Initializes a new User object.
     */
    public User(String userName,String email){
        this.userName = userName;
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    /**
     * Removes a task from the user's task list.
     * requires: Task is not null.
     * effects: If the task is present in list, removes the task.
     */
    public void removeTask(Task task){
        this.tasks.remove(task);
    }

    /**
     * Checks if user has task.
     * requires: Task is not null.
     * effects: Returns true, if the task is present in list.
     */
    public boolean hasTask(Task task){
        return this.tasks.contains(task);
    }

    /**
     *Adds a task to user's task list.
     * requires: Task is not null.
     * effects: If the task is not already in the list, adds the task.
     */
    public void addTask(Task task){
        if (task != null && !this.tasks.contains(task)){
            this.tasks.add(task);
        }
    }

    /**
     * Returns a list of all tasks of user.
     * requires: Nothing.
     * effects: Returns a new list containing all tasks in user's task list.
     */
    public List<Task> getAllTasks(){
        return  new ArrayList<>(this.tasks);
    }

    /**
     * Returns the userName.
     * requires: Nothing.
     * effects: Gives userName.
     */
    public String getUserName(){
        return  userName;
    }

    /**
     * Compares this user and object.If the argument is not null and User object has
     *  same username, the result is tru.
     *  requires: Nothing.
     *  effects: Returns true if objects are equal to userName.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return Objects.equals(userName,user.userName);
    }
}
