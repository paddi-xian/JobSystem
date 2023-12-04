package com.student.job.mapper;

import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobMapper {

    int updateStatusByJob(@Param("j_id")Integer jId,@Param("j_status")String j_status);
    List<Job> selectJobByUid(@Param("u_id") Integer uId);

    boolean addJob(Job job);

    int deleteJobByJID(Integer jId);

    boolean editJob(Job job);

    List<Job> selectAllJob();


    Job_Publisher SelectJobByJid(Integer jId);

    List<Job> SelectJobByLikeName(Job job);

    List<Job_Publisher> SelectJob_publish();

    int AddRecord(@Param("j_id") Integer jId,@Param("u_id") Integer uId);


    Job_Publisher isRecord(@Param("jids")List<Integer> jids,@Param("j_id") Integer jId, @Param("u_id") Integer uId);

    @Select("SELECT j_id FROM record WHERE u_id = #{u_id}")
    List<Integer> selectjids(Integer jId);
}
