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
public class TaskManagerService implements TaskManagerServiceInterface {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private RoleRepository roleRepository;
    @Autowired
    public TaskManagerService(UserRepository userRepository, TaskRepository taskRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Task addTaskByUser(long userId, String taskName, LocalDateTime taskStartDate, LocalDateTime taskEndDate, TaskCategory taskCategory, long quantity, String location) {
        if (userRepository.existsById(userId)){
            User taskUser = userRepository.findById(userId).get();
            return taskRepository.save(new Task(taskName, taskStartDate, taskEndDate, taskCategory, quantity, location, taskUser));
        }
        return null;
    }

    @Override
    public List<Task> getAllTask() {

        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "taskStartDate"));

    }
    @Override
    public Optional<Task> GetTaskById(long userId) {

        return taskRepository.findById(userId);

    }



}

