package com.ciandt.institute.institutetraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciandt.institute.institutetraining.R;
import com.ciandt.institute.institutetraining.model.Task;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<Task> implements View.OnClickListener {

    private ArrayList<Task> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView description;
        ImageView deleteButton;
    }

    public TaskListAdapter(ArrayList<Task> data, Context context) {
        super(context, R.layout.task_row_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Task task = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.task_row_item, parent, false);

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.description = (TextView) convertView.findViewById(R.id.description);
        viewHolder.deleteButton = (ImageView) convertView.findViewById(R.id.delete_button);

        viewHolder.description.setText(task.getDescription());
        //viewHolder.deleteButton.setOnClickListener();

        return convertView;
    }

}
