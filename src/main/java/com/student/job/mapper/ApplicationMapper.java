package com.student.job.mapper;

import com.student.job.pojo.Application;

public interface ApplicationMapper {
    int addApplication(Application application);
    int checkDuplicate(int s_id, int j_id);


}
