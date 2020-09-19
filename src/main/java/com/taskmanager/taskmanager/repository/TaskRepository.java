package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskCategory;
import com.taskmanager.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
List<Task> findAllByTaskUserAndTaskCategory(User taskUser, TaskCategory taskCategory);
List<Task> findAllByTaskUser(User taskUser);

}
