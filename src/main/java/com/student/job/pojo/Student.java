package com.student.job.pojo;

public class Student {
    private Integer s_id;
    private String s_name;
    private String s_gender;
    private Integer s_age;
    private String s_phone;
    private String s_email;

    public Student() {
    }

    public Student(int s_id, String s_name, String s_gender, Integer s_age, String s_phone, String s_email) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_gender = s_gender;
        this.s_age = s_age;
        this.s_phone = s_phone;
        this.s_email = s_email;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_gender() {
        return s_gender;
    }

    public void setS_gender(String s_gender) {
        this.s_gender = s_gender;
    }

    public Integer getS_age() {
        return s_age;
    }

    public void setS_age(Integer s_age) {
        this.s_age = s_age;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_gender='" + s_gender + '\'' +
                ", s_age=" + s_age +
                ", s_phone='" + s_phone + '\'' +
                ", s_email='" + s_email + '\'' +
                '}';
    }
}
