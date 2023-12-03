package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job_Publisher {
    private Integer j_id;
    private String j_name;
    private String j_description;
    private String j_require;
    private Double j_salary;
    private String j_hours;
    private String j_status;
    private Integer u_id;
    private Integer p_id;
    private String p_name;
    private String p_telephone;
    private String p_address;
    private String p_email;
    private String p_introduction;
}
