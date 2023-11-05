package com.student.job.pojo;

import com.student.job.service.JobService;
import com.student.job.service.impl.JobServiceImpl;

public class BeanFactory {
    private static final JobService jobService;

    static {
        jobService = new JobServiceImpl();
    }

    public static Object getBean(String bean) {
        if(bean.equals("jobService")) {
            return jobService;
        }
        return null;
    }
}
