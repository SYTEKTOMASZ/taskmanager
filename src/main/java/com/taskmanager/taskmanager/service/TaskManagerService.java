package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.Role;
import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.repository.RoleRepository;
import com.taskmanager.taskmanager.repository.UserRepository;
import com.taskmanager.taskmanager.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.taskmanager.taskmanager.repository.TaskRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerService implements TaskManagerServiceInterface {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private RoleRepository roleRepository;
    private TaskCategoryRepository taskCategoryRepository;

    @Autowired
    public TaskManagerService(UserRepository userRepository, TaskRepository taskRepository, RoleRepository roleRepository,TaskCategoryRepository taskCategoryRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.roleRepository = roleRepository;
        this.taskCategoryRepository = taskCategoryRepository;
    }

    @Override
    public Task addTaskByUser(long userId, String taskName, LocalDateTime taskStartDate, LocalDateTime taskEndDate, String taskCategoryName, long quantity, String location) {
        if (userRepository.existsById(userId)) {
            User taskUser = userRepository.findById(userId).get();
            if(taskCategoryRepository.findFirstByCategoryName(taskCategoryName)!=null) {
                TaskCategory taskCategory = taskCategoryRepository.findById(taskCategoryRepository.findFirstByCategoryName(taskCategoryName).getCategoryId()).get();
                return taskRepository.save(new Task(taskName, taskStartDate, taskEndDate, taskCategory, quantity, location, taskUser));
            }
            return null;
            }
        return null;
    }

    @Override
    public List<Task> getAllTask() {

        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "taskStartDate"));

    }

    @Override
    public List<Task> getTaskByUser(long userId) {

        return taskRepository.findAllByTaskUser(userRepository.findById(userId).get());

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUser(User user) {
        if (userRepository.findFirstByName(user.getName()) == null) {
            addRoleToUser(user, "ROLE_USER");
            userRepository.save(user);   // INSERT INTO user VALUES (?,?,?,?,?);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User addRoleToUser(User user, String roleName) {
        Role role = roleRepository.findFirstByRoleName(roleName);
        user.getRoles().add(role);
        return user;


    }

    @Override
    public boolean addTaskCategory(TaskCategory taskCategory) {
        if (taskCategoryRepository.findFirstByCategoryName(taskCategory.getCategoryName()) == null) {
            taskCategoryRepository.save(taskCategory);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Task> getTaskByTaskUserAndTaskCategory(long userId, String taskCategoryName) {

        return taskRepository.findAllByTaskUserAndTaskCategory(userRepository.findById(userId).get(),taskCategoryRepository.findById(taskCategoryRepository.findFirstByCategoryName(taskCategoryName).getCategoryId()).get());

    }
}

