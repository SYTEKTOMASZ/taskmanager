package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
