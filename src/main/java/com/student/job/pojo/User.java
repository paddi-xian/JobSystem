package com.student.job.pojo;

public class User {
    private String u_id;
    private String u_name;
    private String u_pass;
    private String telephone;
    private String role;

    public User() {
    }

    public User(String u_id, String u_name, String u_pass, String role, String telephone) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pass = u_pass;
        this.role = role;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_pass='" + u_pass + '\'' +
                ", role='" + role + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public enum Role{
        ADMIN,
        PUBLISHER,
        STUDENT
    }

}
