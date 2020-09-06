package com.taskmanager.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

@NotBlank(message = "field name is mandatory")
private String name;

@NotBlank(message = "field password is mandatory")
@Size(min = 6, max = 255,
            message = "password requires at least {min} characters (not more than {max})")
private String password;

private LocalDateTime registrationDateTime;

private boolean status;

    @ManyToMany
    @JoinTable(
            name = "user_has_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();



}
