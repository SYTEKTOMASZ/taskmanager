package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findFirstByRoleName(String roleName);
}
