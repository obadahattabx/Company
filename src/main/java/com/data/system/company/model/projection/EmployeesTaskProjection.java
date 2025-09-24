package com.data.system.company.model.projection;

import com.data.system.company.model.entity.Tasks;

import java.util.List;

public interface EmployeesTaskProjection {
    String getId();
    String getFirstname();
    String getLastname();
    String getEmail();
    String getPhoneNumber();
    double getSalary();
    List<TaskInfo> getTasks();


     interface  TaskInfo{
        int getId();
        String getTitle();
        String getDesc();
        Tasks.TaskPriority getPriority();
        int getEstaimatedHours();

    }

}
