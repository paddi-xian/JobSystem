package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer s_id;
    private String s_name;
    private String s_gender;
    private Integer s_age;
    private String s_phone;
    private String s_email;
    private String s_intro;
    private Integer u_id;





}
