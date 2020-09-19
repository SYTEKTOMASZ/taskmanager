package com.taskmanager.taskmanager.repository;
import com.taskmanager.taskmanager.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
//        TaskCategory findFirstByCategoryName(String name);
        TaskCategory findFirstByCategoryName(String categoryName);
        }