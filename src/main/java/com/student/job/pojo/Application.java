package com.student.job.pojo;

import java.util.Date;

public class Application {
    private String a_id;
    private String s_id;
    private String j_id;
    private Date a_time;
    private String a_status;

    public Application() {
    }

    public Application(String a_id, String s_id, String j_id, Date a_time, String a_status) {
        this.a_id = a_id;
        this.s_id = s_id;
        this.j_id = j_id;
        this.a_time = a_time;
        this.a_status = a_status;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getJ_id() {
        return j_id;
    }

    public void setJ_id(String j_id) {
        this.j_id = j_id;
    }

    public Date getA_time() {
        return a_time;
    }

    public void setA_time(Date a_time) {
        this.a_time = a_time;
    }

    public String getA_status() {
        return a_status;
    }

    public void setA_status(String a_status) {
        this.a_status = a_status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "a_id='" + a_id + '\'' +
                ", s_id='" + s_id + '\'' +
                ", j_id='" + j_id + '\'' +
                ", a_time=" + a_time +
                ", a_status='" + a_status + '\'' +
                '}';
    }
}
