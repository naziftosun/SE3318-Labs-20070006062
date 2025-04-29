package org.example;

import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean completed;


    /**
     * Creates a new Task with the given title and due date.
     * The task is initially marked as not completed.
     * requires: title is not null and not empty,dueDate is not null.
     * effects: Initializes a new Task object with the specified title and due date,
     * and sets its completed status to false.
     */

    public Task(String title, LocalDate dueDate){
        this.title = title;
        this.dueDate = dueDate;
        this.completed = false;
    }

    /**
     *Checks if the task is overdue.
     * requires: Nothing.
     * effects: Returns true if condition is true, otherwise retuns false.
     */

    public boolean isOverdue(){
        return LocalDate.now().isAfter(this.dueDate) && !this.completed;
    }

    /**
     * Set the task is completed.
     * requires: Nothing.
     * effects: Sets completion to true.
     */
    public  void Completed(){
        this.completed = true;
    }

    public  LocalDate getDueDate(){
        return dueDate;
    }

    /**
     *Returns the title of task.
     * requires: Nothing.
     * effects: Returns the value of this.title.
     */
    public String getTitle(){
        return title;
    }

    public boolean isCompleted(){
        return completed;
    }

    /**
     *Compare this task and object.If the argument is not null and is a Task
     *  object, the result is true.
     *  requires: Nothing.
     *  effects: Returns true if objects are equal.
     */

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Task task = (Task) o;
        return java.util.Objects.equals(title, task.title) && java.util.Objects.equals(dueDate, task.dueDate);
    }



}
