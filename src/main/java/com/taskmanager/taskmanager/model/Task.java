package com.taskmanager.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    @NotBlank(message = "field name is mandatory")
    private String taskName;

    private LocalDateTime taskStartDate;

    private LocalDateTime taskEndDate;

    private TaskCategory taskCategory;

    private long quantity;

    private String location;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User taskUser;


}
