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

//    public Student() {
//    }
//
//    public Student(Integer s_id, String s_name, String s_gender, Integer s_age, String s_phone, String s_email,String s_intro,Integer u_id) {
//        this.s_id = s_id;
//        this.s_name = s_name;
//        this.s_gender = s_gender;
//        this.s_age = s_age;
//        this.s_phone = s_phone;
//        this.s_email = s_email;
//        this.s_intro=s_intro;
//        this.u_id=u_id;
//    }
//
//    public int getS_id() {
//        return s_id;
//    }
//
//    public void setS_id(Integer s_id) {
//        this.s_id = s_id;
//    }
//
//    public String getS_name() {
//        return s_name;
//    }
//
//    public void setS_name(String s_name) {
//        this.s_name = s_name;
//    }
//
//    public String getS_gender() {
//        return s_gender;
//    }
//
//    public void setS_gender(String s_gender) {
//        this.s_gender = s_gender;
//    }
//
//    public Integer getS_age() {
//        return s_age;
//    }
//
//    public void setS_age(Integer s_age) {
//        this.s_age = s_age;
//    }
//
//    public String getS_phone() {
//        return s_phone;
//    }
//
//    public void setS_phone(String s_phone) {
//        this.s_phone = s_phone;
//    }
//
//    public String getS_email() {
//        return s_email;
//    }
//
//    public void setS_email(String s_email) {
//        this.s_email = s_email;
//    }
//
//    public String getS_intro(){return  s_intro;}
//
//    public void setS_intro(String s_intro) {
//        this.s_intro = s_intro;
//    }
//
//    public Integer getU_id()
//    {
//        return u_id;
//    }
//    public void setU_id(Integer u_id) {
//        this.u_id = u_id;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "s_id=" + s_id +
//                ", s_name='" + s_name + '\'' +
//                ", s_gender='" + s_gender + '\'' +
//                ", s_age=" + s_age +
//                ", s_phone='" + s_phone + '\'' +
//                ", s_email='" + s_email + '\'' +
//                ",s_intro='"+s_intro+'\''+
//                '}';
//    }



}
