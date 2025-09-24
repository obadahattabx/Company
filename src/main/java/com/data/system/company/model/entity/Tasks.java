package com.data.system.company.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    private String desc;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", length = 20)
    private TaskPriority priority = TaskPriority.MEDIUM;


    private int estaimatedHours;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAT;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updateAt;





    @ManyToOne(fetch = FetchType.LAZY)
    private Employees employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    public enum TaskPriority{
        LOW,MEDIUM,HIGH
    }
}
