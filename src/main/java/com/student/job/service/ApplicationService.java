package com.student.job.service;

import com.student.job.pojo.Application;
import com.student.job.pojo.Student;

import java.util.List;

public interface ApplicationService {
    int addApplication(Application application);

    List<Application> getApplicationList();
}
