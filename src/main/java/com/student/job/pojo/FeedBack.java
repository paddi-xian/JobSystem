package com.student.job.pojo;

import java.util.Date;

public class FeedBack {
    private String f_id;
    private String s_id;
    private String j_id;
    private String f_content;
    private Date f_time;

    public FeedBack() {
    }

    public FeedBack(String f_id, String s_id, String j_id, String f_content, Date f_time) {
        this.f_id = f_id;
        this.s_id = s_id;
        this.j_id = j_id;
        this.f_content = f_content;
        this.f_time = f_time;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
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

    public String getF_content() {
        return f_content;
    }

    public void setF_content(String f_content) {
        this.f_content = f_content;
    }

    public Date getF_time() {
        return f_time;
    }

    public void setF_time(Date f_time) {
        this.f_time = f_time;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "f_id='" + f_id + '\'' +
                ", s_id='" + s_id + '\'' +
                ", j_id='" + j_id + '\'' +
                ", f_content='" + f_content + '\'' +
                ", f_time=" + f_time +
                '}';
    }
}
