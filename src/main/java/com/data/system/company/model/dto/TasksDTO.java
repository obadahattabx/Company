package com.data.system.company.model.dto;

import com.data.system.company.model.entity.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TasksDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int empolyeesId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int projectId;
    private int id;
    private String title;
    private String desc;
    private Tasks.TaskPriority priority;
    private int estaimatedHours;
    private EmployeesDTO employeesDto;
    private ProjectDTO projectDTO;

}
