package com.ciandt.institute.institutetraining.listener;

import android.view.View;

import com.ciandt.institute.institutetraining.adapter.TaskListAdapter;
import com.ciandt.institute.institutetraining.model.Task;
import com.ciandt.institute.institutetraining.service.TaskService;

public class DeleteTaskListener implements View.OnClickListener {

    Task task;
    TaskListAdapter taskListAdapter;

    public DeleteTaskListener(TaskListAdapter taskListAdapter, Task task) {
        this.task = task;
        this.taskListAdapter = taskListAdapter;
    }

    @Override
    public void onClick(View v) {

        TaskService taskService = new TaskService(taskListAdapter.getContext());
        taskService.delete(task);

        taskListAdapter.remove(task);
        taskListAdapter.notifyDataSetChanged();
    }
}
