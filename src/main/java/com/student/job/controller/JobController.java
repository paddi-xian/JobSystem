package com.student.job.controller;

import com.student.job.pojo.Job;
import com.student.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
//@RequestMapping("/job")
public class JobController {
    @Resource
    public JobService jobService;


//    @GetMapping("/updateStatus")
//    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
//    public String updateStatusByJob(@RequestParam("j_id") Integer j_id, @RequestParam("j_status") String j_status) {
//        jobService.updateStatusByJob(j_id, j_status);
//        return "更新成功！";
//    }


}
