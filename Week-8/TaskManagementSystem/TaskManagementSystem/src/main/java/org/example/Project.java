package org.example;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private  String projectName;
    private List<User> users;
    private List<Task> tasks;

    /**
     * Creates a new Project with the given name.
     * requires: projectName is not null and not empty.
     * effects: Set a new project object with the name and empty lists for users and tasks.
     */
    public Project(String projectName){
        this.projectName = projectName;
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a user to the project if the user is not null and not already in the project.
     * requires: User is not null.
     * effects: If the user is not already in the Project's user list, adds the user.
     */
    public void addUser(User user){
        if(user != null && !this.users.contains(user)){
            this.users.add(user);
        }
    }

    /**
     * Adds a task to the project if the task is not null.
     * requires: Task is not null.
     * effects: Adds the task.
     */
    public void addTask(Task task){
        if (task != null && !this.tasks.contains(task)){
            this.tasks.add(task);
        }
    }

    /**
     * Returns a task from project by its title.
     * requires: Title is not null.
     * effects: Returns the first task found in the task list.
     */
    public Task getTask(String title){
        for (Task task : tasks){
            if (task.getTitle().equalsIgnoreCase(title)){
                return task;
            }
        }
        return null;
    }

    /**
     * Returns the name of project.
     * requires: Nothing.
     * effects: Returns the projectName.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Returns a list of users.
     * requires: Nothing.
     * effects: Returns a new list containing all users in the project.
     */
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Returns a list of tasks.
     * requires: Nothing.
     * effects: Returns a new list containing all tasks in project's task list.
     */
    public List<Task> getTasks(){
        return new ArrayList<>(tasks);
    }



}
