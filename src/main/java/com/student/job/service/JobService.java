package com.student.job.service;

import com.student.job.pojo.Job;

import java.util.List;

public interface JobService {

    /**
     * 添加岗位
     * @param j_id
     * @param j_name
     * @param j_description
     * @param j_salary
     * @param j_hours
     */
    void addJob(String j_id,String j_name,String j_description,Double j_salary,String j_hours);


    /**
     * 删除岗位
     * @param j_id
     */
    void deleteJob(String j_id);


    /**
     * 修改岗位
     * @param j_id
     * @param j_name
     * @param j_description
     * @param j_salary
     * @param j_hours
     */
    void updateJob(String j_id, String j_name, String j_description, Double j_salary, String j_hours);

    List<Job> selectById(String j_id);

}
