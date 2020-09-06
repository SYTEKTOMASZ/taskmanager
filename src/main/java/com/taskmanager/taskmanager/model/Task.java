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

    public Task(long taskId, LocalDateTime taskStartDate, LocalDateTime taskEndDate, TaskCategory taskCategory, long quantity, String location, User taskUser) {
        this.taskId = taskId;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskCategory = taskCategory;
        this.quantity = quantity;
        this.location = location;
        this.taskUser = taskUser;
    }


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
