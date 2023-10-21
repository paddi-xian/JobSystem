package com.student.job.mapper;

import com.student.job.pojo.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JobMapper {


    List<Job> selectJobByUid(@Param("u_id") Integer uId);
}
