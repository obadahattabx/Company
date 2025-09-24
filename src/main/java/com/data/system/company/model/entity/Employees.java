package com.data.system.company.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"id","firstname","lastname","email","phoneNumber","salary","createAt","updateAt"})
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name" ,nullable = false ,length = 40)
    private String firstname;

    @Column(name = "last_name",nullable = false,length = 40)
    private  String lastname;

    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @Column(name = "phone_number",length = 20)
    private String phoneNumber;

    private double salary;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private  LocalDateTime updateAt;

    @ManyToOne
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projectList;

    @OneToMany(mappedBy = "employees")
    private List<Tasks> tasks;


}
