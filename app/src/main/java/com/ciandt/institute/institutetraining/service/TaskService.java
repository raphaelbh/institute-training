package com.ciandt.institute.institutetraining.service;

import android.content.Context;
import android.widget.Toast;

import com.ciandt.institute.institutetraining.model.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    public static final String DATA_STORAGE_FILE = "storage.json";

    private Context context;

    public TaskService(Context context) {
        this.context = context;
    }

    /**
     * Save the task in the data storage.
     * @param task
     * @return saved task.
     */
    public Task save(Task task) {

        List<Task> tasks = getAll();
        tasks.add(task);

        if(updateDataStorage(tasks)) {
            Toast.makeText(context, "Task saved.",
                    Toast.LENGTH_SHORT).show();
        }

        return task;
    }

    /**
     * Delete the task of the data storage.
     * @param task
     * @return id of deleted task.
     */
    public String delete(Task task) {

        List<Task> tasks = getAll();
        for (Task baseTask  : tasks) {

            if (baseTask.getId().equals(task.getId())) {
                tasks.remove(baseTask);
                break;
            }

        }

        if(updateDataStorage(tasks)) {
            Toast.makeText(context, "Task deleted.",
                    Toast.LENGTH_SHORT).show();
        }

        return task.getId();
    }

    /**
     * Get all storaged tasks.
     * @return tasks.
     */
    public List<Task> getAll() {

        String data = readDataStorage();
        return convertDataStorageToTasks(data);

    }

    private Boolean updateDataStorage(List<Task> tasks) {
        JSONArray tasksToSave = convertTasksToDataStorage(tasks);
        writeDataStorage(tasksToSave);
        return Boolean.TRUE;
    }

    private String readDataStorage() {

        String readData = "";

        File file = context.getFileStreamPath(DATA_STORAGE_FILE);
        if (file == null || !file.exists()) return readData;

        try {
            FileInputStream fileIn = context.openFileInput(DATA_STORAGE_FILE);
            InputStreamReader inputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[100000];
            int charRead;

            while ((charRead = inputRead.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                readData +=readString;
            }
            inputRead.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Unable to read data store",
                    Toast.LENGTH_SHORT).show();
        }

        return readData;
    }

    private List<Task> convertDataStorageToTasks(String data) {

        List<Task> tasks = new ArrayList<Task>();
        if (data == null || data.isEmpty()) return tasks;

        try {

            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject object = jsonArray.getJSONObject(i);
                String id = object.getString("id");
                String description = object.getString("description");

                Task task = new Task();
                task.setId(id);
                task.setDescription(description);

                tasks.add(task);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Unable to convert data store to json",
                    Toast.LENGTH_SHORT).show();
            return null;
        }

        return tasks;
    }

    private Boolean writeDataStorage(JSONArray tasks) {

        try {
            FileOutputStream fileOut = context.openFileOutput(DATA_STORAGE_FILE, context.MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileOut);
            outputWriter.write(tasks.toString());
            outputWriter.close();

            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    private JSONArray convertTasksToDataStorage(List<Task> tasks) {

        JSONArray jsonArray = new JSONArray();
        for (Task task : tasks) {

            try {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", task.getId());
                jsonObject.put("description", task.getDescription());

                jsonArray.put(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "Unable to convert json to data store",
                        Toast.LENGTH_SHORT).show();
                return null;
            }

        }

        return jsonArray;
    }

}
