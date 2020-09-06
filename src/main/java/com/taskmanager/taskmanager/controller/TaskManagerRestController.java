package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.service.TaskManagerService;
import jdk.jfr.Category;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class TaskManagerRestController {
    private TaskManagerService taskManagerService;
    @Autowired
    public TaskManagerRestController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/")
    public List<Task> getAllTasks(){
        return taskManagerService.getAllTask();
    }

    @GetMapping("/addTask")
    public Task addTaskByUser(
            @RequestParam("userID") Long userID,
            @RequestParam("taskName") String taskName,
            @RequestParam("taskStartDate") String taskStartDate,
            @RequestParam("taskEndDate") String taskEndDate,
            @RequestParam("taskCategory")TaskCategory taskCategory,
            @RequestParam("quantity") Long quantity,
            @RequestParam("location") String location)
    {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm");
        LocalDateTime start_date = LocalDateTime.parse(taskStartDate, FOMATTER);
        LocalDateTime stop_date = LocalDateTime.parse(taskEndDate, FOMATTER);
        System.out.println("FORMATTER: " + start_date);
        return taskManagerService.addTaskByUser(
                userID,
                taskName,
                start_date,
                stop_date,
                taskCategory,
                quantity,
                location);
    }




}
