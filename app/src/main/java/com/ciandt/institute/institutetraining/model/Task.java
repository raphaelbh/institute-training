package com.ciandt.institute.institutetraining.model;

import java.io.Serializable;

public class Task implements Serializable {

    private String id;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "{'id':'"+this.getId()+"', 'description':'"+this.getDescription()+"'}";
    }
}
