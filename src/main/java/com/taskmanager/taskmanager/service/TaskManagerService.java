package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.repository.RoleRepository;
import com.taskmanager.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.taskmanager.taskmanager.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerService {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private RoleRepository roleRepository;
    @Autowired
    public TaskManagerService(UserRepository userRepository, TaskRepository taskRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.roleRepository = roleRepository;
    }

    public List<Task> getAllTask() {

        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "taskStartDate"));

    }

    public Optional<Task> GetTaskByID(long taskId) {

        return taskRepository.findById(taskId);

    }

    public Task addTaskByUser(long taskId, LocalDateTime taskStartDate, LocalDateTime taskEndDate, TaskCategory taskCategory, long quantity, String location, User taskUser) {
        return taskRepository.save(new Task(taskId, taskStartDate, taskEndDate, taskCategory, quantity, location, taskUser));
    }


}

