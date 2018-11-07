package com.ciandt.institute.institutetraining.listener;

import android.view.View;

import com.ciandt.institute.institutetraining.adapter.TaskListAdapter;
import com.ciandt.institute.institutetraining.model.Task;

import java.util.ArrayList;

public class DeleteTaskListener implements View.OnClickListener {

    Task task;
    ArrayList<Task> tasks;
    TaskListAdapter taskListAdapter;

    public DeleteTaskListener(TaskListAdapter taskListAdapter, ArrayList<Task> tasks, Task task) {
        this.task = task;
        this.tasks = tasks;
        this.taskListAdapter = taskListAdapter;
    }

    @Override
    public void onClick(View v) {

        if (tasks.contains(task)) {
            tasks.remove(task);
        }

        taskListAdapter.notifyDataSetChanged();
    }
}
