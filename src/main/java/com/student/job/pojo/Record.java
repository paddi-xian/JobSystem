package com.student.job.pojo;

import java.util.Date;

public class Record {
    private Integer r_id;
    private Integer s_id;
    private Integer j_id;
    private Date startTime;
    private Date endTime;
    private Date workTime;

    public Record() {
    }

    public Record(int r_id, int s_id, int j_id, Date startTime, Date endTime, Date workTime) {
        this.r_id = r_id;
        this.s_id = s_id;
        this.j_id = j_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workTime = workTime;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "r_id=" + r_id +
                ", s_id=" + s_id +
                ", j_id=" + j_id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", workTime=" + workTime +
                '}';
    }
}
