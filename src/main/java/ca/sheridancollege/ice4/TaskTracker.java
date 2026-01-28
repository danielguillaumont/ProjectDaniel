package ca.sheridancollege.ice4;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskTracker is a lightweight utility class used to demonstrate
 * feature-based development and branching for ICE4.
 */
public class TaskTracker {

    private List<String> tasks;

    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        if (task != null && !task.isBlank()) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public int getTotalTasks() {
        return tasks.size();
    }

    public void displayTasks() {
        System.out.println("ICE4 Task Tracker:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
