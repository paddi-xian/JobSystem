package com.student.job.pojo;


public class Job {
    private int j_id;
    private String j_name;
    private String j_description;
    private Double j_salary;
    private String j_hours;

    public Job() {
    }

    public Job(int j_id, String j_name, String j_description, Double j_salary, String j_hours) {
        this.j_id = j_id;
        this.j_name = j_name;
        this.j_description = j_description;
        this.j_salary = j_salary;
        this.j_hours = j_hours;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public String getJ_description() {
        return j_description;
    }

    public void setJ_description(String j_description) {
        this.j_description = j_description;
    }

    public Double getJ_salary() {
        return j_salary;
    }

    public void setJ_salary(Double j_salary) {
        this.j_salary = j_salary;
    }

    public String getJ_hours() {
        return j_hours;
    }

    public void setJ_hours(String j_hours) {
        this.j_hours = j_hours;
    }

    @Override
    public String toString() {
        return "Job{" +
                "j_id=" + j_id +
                ", j_name='" + j_name + '\'' +
                ", j_description='" + j_description + '\'' +
                ", j_salary=" + j_salary +
                ", j_hours='" + j_hours + '\'' +
                '}';
    }
}
