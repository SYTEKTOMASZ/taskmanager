package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class TaskManagerRestController {
    private TaskManagerService taskManagerService;

    @Autowired
    public TaskManagerRestController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskManagerService.getAllTask();
    }

    @PostMapping("/addTask")
    public Task addTaskByUser(
            @RequestParam("userID") Long userID,
            @RequestParam("taskName") String taskName,
            @RequestParam("taskStartDate") String taskStartDate,
            @RequestParam("taskEndDate") String taskEndDate,
            @RequestParam("taskCategory") String taskCategoryName,
            @RequestParam("quantity") Long quantity,
            @RequestParam("location") String location) {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start_date = LocalDateTime.parse(taskStartDate, FOMATTER);
        LocalDateTime stop_date = LocalDateTime.parse(taskEndDate, FOMATTER);
        System.out.println("FORMATTER: " + start_date);
        return taskManagerService.addTaskByUser(
                userID,
                taskName,
                start_date,
                stop_date,
                taskCategoryName,
                quantity,
                location);
    }

    @GetMapping("/userList")
    public List<User> getAllUsers() {
        return taskManagerService.getAllUsers();
    }

    @PostMapping("/addUser")
    public boolean addUser(
            @RequestParam("name") String name,
            @RequestParam("password") String passowrd
    ){
        return taskManagerService.addUser(new User(name, passowrd));
    }

    @PostMapping("/addTaskCategorry")
    public boolean addTaskCategory(
            @RequestParam("categoryName") String categoryName
    ){
        return taskManagerService.addTaskCategory(new TaskCategory(categoryName));

    }

    @GetMapping("/tasks/{userId}")
    public List<Task> getTaskByUser(
            @PathVariable("userId") long userId
    ){
        return taskManagerService.getTaskByUser(userId);
    }

    @GetMapping("/tasks/{userId}/{taskCategoryName}")
    public List<Task> getTaskByIdAndTaskCategory(
            @PathVariable("userId") long userId,
            @PathVariable("taskCategoryName") String taskCategoryName
    ){
        return taskManagerService.getTaskByTaskUserAndTaskCategory(userId, taskCategoryName) ;
    }






}
