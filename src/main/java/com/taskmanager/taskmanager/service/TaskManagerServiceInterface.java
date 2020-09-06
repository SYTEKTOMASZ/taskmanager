package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.model.User;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskManagerServiceInterface {

    //add task
    Task addTaskByUser(long userId, String taskName, LocalDateTime taskStartDate, LocalDateTime taskEndDate, TaskCategory taskCategory, long quantity, String location);
    // get all task
    List<Task> getAllTask();
    // get all task by User ID
    Optional<Task> GetTaskById(long userID);



}