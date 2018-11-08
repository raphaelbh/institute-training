package com.ciandt.institute.institutetraining.repository;

import com.ciandt.institute.institutetraining.model.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskRepository implements Serializable {

    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskRepository() {

        Task task1 = new Task();
        task1.setId(1);
        task1.setDescription("description 1...");

        Task task2 = new Task();
        task2.setId(2);
        task2.setDescription("description 2...");

        Task task3 = new Task();
        task3.setId(3);
        task3.setDescription("description 3...");

        add(task1);
        add(task2);
        add(task3);
    }

    public Task add(final Task task) {
        tasks.add(task);
        return task;
    }

    public void delete(final Task task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
        }
    }

    public ArrayList<Task> getAll() {
        return tasks;
    }
}
