package com.taskmanager.taskmanager.model;

public enum TaskCategoryEnum {

    READING("Reading"),
    BREAK("Break"),
    RUNNING("Running"),
    PUSHUPS("Pushups"),
    LEARING("Learning"),
    CODING("Coding"),
    WORK("Work");



    private String name;

    TaskCategoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
