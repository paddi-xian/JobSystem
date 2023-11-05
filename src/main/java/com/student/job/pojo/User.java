package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer u_id;
    private String u_name;
    private String u_pass;
    private String telephone;
    private String role;

}
