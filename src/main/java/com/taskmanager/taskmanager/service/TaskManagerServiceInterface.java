package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskManagerServiceInterface {

    //add task
    Task addTaskByUser(long userId, String taskName, LocalDateTime taskStartDate, LocalDateTime taskEndDate, String taskCategoryName, long quantity, String location);
    // get all task
    List<Task> getAllTask();
    // get all task by User ID
    List<Task> getTaskByUser(long UserId);
    // get all User
    List<User> getAllUsers();
    // dodawanie użytkownika
    boolean addUser(User user);
    // nadawanie roli użytkownikowi
    User addRoleToUser(User user, String roleName);
    // add taskCategory
    boolean addTaskCategory(TaskCategory taskCategory);
    // get all task by user ID and task category
    List<Task> getTaskByTaskUserAndTaskCategory(long userId, String taskCategoryName);
}