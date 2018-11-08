package com.ciandt.institute.institutetraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ciandt.institute.institutetraining.model.Task;
import com.ciandt.institute.institutetraining.repository.TaskRepository;

public class CreateTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        Button saveButton = (Button) findViewById(R.id.save_task_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Bundle extras = getIntent().getExtras();
                if (extras != null && extras.containsKey("taskRepository")) {

                    EditText inputDescription = (EditText) findViewById(R.id.description_task);

                    TaskRepository taskRepository = (TaskRepository) extras.get("taskRepository");
                    Task lastTask = taskRepository.getAll().get(taskRepository.getAll().size() - 1);

                    Task task = new Task();
                    task.setId(lastTask.getId() + 1);
                    task.setDescription(inputDescription.getText().toString());

                    taskRepository.add(task);

                    Intent intent = new Intent(CreateTaskActivity.this,
                            MainActivity.class);
                    intent.putExtra("taskRepository", taskRepository);
                    startActivity(intent);

                }

            }

        });

    }

}
