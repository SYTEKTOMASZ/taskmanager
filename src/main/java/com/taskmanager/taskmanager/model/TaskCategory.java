package com.taskmanager.taskmanager.model;

public enum TaskCategory {

    READING("Reading"),
    BREAK("Break"),
    RUNNING("Running"),
    PUSHUPS("Pushups"),
    LEARING("Learning"),
    WORK("Work");


    private String name;

    TaskCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
