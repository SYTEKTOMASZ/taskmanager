package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<Entity, Primary key type>

    // SELECT * FROM user WHERE user.email = ? LIMIT 1
    User findFirstByName(String name);


}

