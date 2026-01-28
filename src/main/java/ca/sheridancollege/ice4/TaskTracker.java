package ca.sheridancollege.ice4;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskTracker is a lightweight utility class used to demonstrate
 * feature-based development and branching for ICE4.
 *
 * Feature additions (tasktracker-enhancements):
 * - Prevent duplicate tasks (case-insensitive)
 * - Mark tasks as completed
 * - Remove tasks by index safely
 * - Search tasks by keyword
 * - Display tasks with completion status
 */
public class TaskTracker {

    // Inner class
    private static class TaskItem {
        private final String description;
        private boolean completed;

        public TaskItem(String description) {
            this.description = description;
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            this.completed = true;
        }
    }

    private final List<TaskItem> tasks;

    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task if it is non-empty and not a duplicate (case-insensitive).
     * @return true if the task was added, false otherwise
     */
    public boolean addTask(String task) {
        if (task == null || task.isBlank()) {
            return false;
        }

        String normalized = task.trim().toLowerCase();

        for (TaskItem t : tasks) {
            if (t.getDescription().trim().toLowerCase().equals(normalized)) {
                return false; // duplicate
            }
        }

        tasks.add(new TaskItem(task.trim()));
        return true;
    }

    /**
     * Marks a task as completed by index (1-based for user friendliness).
     * @return true if successful, false if index is invalid
     */
    public boolean completeTask(int taskNumber) {
        int index = taskNumber - 1;
        if (index < 0 || index >= tasks.size()) {
            return false;
        }

        tasks.get(index).markCompleted();
        return true;
    }

    /**
     * Removes a task by index (1-based).
     * @return true if removed, false if index invalid
     */
    public boolean removeTask(int taskNumber) {
        int index = taskNumber - 1;
        if (index < 0 || index >= tasks.size()) {
            return false;
        }

        tasks.remove(index);
        return true;
    }

    /**
     * Searches tasks containing a keyword (case-insensitive).
     * @return list of matching task descriptions
     */
    public List<String> search(String keyword) {
        List<String> results = new ArrayList<>();
        if (keyword == null || keyword.isBlank()) {
            return results;
        }

        String key = keyword.trim().toLowerCase();

        for (TaskItem t : tasks) {
            if (t.getDescription().toLowerCase().contains(key)) {
                results.add(t.getDescription());
            }
        }

        return results;
    }

    public int getTotalTasks() {
        return tasks.size();
    }

    public void displayTasks() {
        System.out.println("ICE4 Task Tracker:");

        if (tasks.isEmpty()) {
            System.out.println("(no tasks yet)");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            TaskItem t = tasks.get(i);
            String status = t.isCompleted() ? "[DONE]" : "[TODO]";
            System.out.println((i + 1) + ". " + status + " " + t.getDescription());
        }
    }
}
