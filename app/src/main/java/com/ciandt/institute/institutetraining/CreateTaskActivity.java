package com.ciandt.institute.institutetraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;

import com.ciandt.institute.institutetraining.model.Task;
import com.ciandt.institute.institutetraining.service.TaskService;

import static java.util.UUID.*;

public class CreateTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.save_task_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText inputDescription = (EditText) findViewById(R.id.description_task);
                String description = inputDescription.getText().toString();

                // TODO: Criar a atividade aqui

                Intent intent = new Intent(CreateTaskActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });

    }

}
