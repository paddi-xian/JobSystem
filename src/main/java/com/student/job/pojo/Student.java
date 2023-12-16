package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable,Cloneable{
    private Integer s_id;
    private String s_name;
    private String s_gender;
    private Integer s_age;
    private String s_phone;
    private String s_email;
    private String s_intro;
    private Integer u_id;
    private String s_college;
    private String s_prize;
    private String s_experience;
    private String s_job;
    private String j_name;
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }


}
