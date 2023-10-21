package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private Integer j_id;
    private String j_name;
    private String j_description;
    private Double j_salary;
    private String j_hours;
    private Integer u_id;

}
