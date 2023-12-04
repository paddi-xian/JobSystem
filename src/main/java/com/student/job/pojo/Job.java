package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {
    private Integer j_id;
    private String j_name;
    private String j_description;
    private String j_require;
    private Double j_salary;
    private String j_hours;
    private String j_status;
    private Integer u_id;
    //多表查询
    private String p_name;
}
