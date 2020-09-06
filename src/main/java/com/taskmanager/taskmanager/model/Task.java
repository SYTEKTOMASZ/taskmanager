package com.taskmanager.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    public Task(String taskName, LocalDateTime taskStartDate, LocalDateTime taskEndDate, TaskCategory taskCategory, long quantity, String location, User taskUser) {
        this.taskStartDate = taskStartDate;
        this.taskName = taskName;
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
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime taskStartDate;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime taskEndDate;

    private TaskCategory taskCategory;

    private long quantity;

    private String location;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User taskUser;


}
