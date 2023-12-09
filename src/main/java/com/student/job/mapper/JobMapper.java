package com.student.job.mapper;

import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Record;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobMapper {
    int selectJIdsByUId(@Param("u_id") Integer uId);

    int updateStatusByJob(@Param("j_id")Integer jId,@Param("j_status")String j_status);
    List<Job> selectJobByUid(@Param("u_id") Integer uId);
    List<Job> selectJobByStuUid(@Param("u_id")Integer uId);
    boolean addJob(Job job);

    int deleteJobByJID(Integer jId);

    boolean editJob(Job_Publisher job);

    List<Job> selectAllJob();


    Job_Publisher SelectJobByJid(Integer jId);

    List<Job_Publisher> SelectJobByLikeName(@Param("str") String str,@Param("u_id") Integer uId);

    List<Job_Publisher> SelectJob_publish();

    int AddRecord(@Param("j_id") Integer jId,@Param("u_id") Integer uId);



    @Select("SELECT j_id,j_name,j_description,j_salary,j_hours,j_require,j_status,p_name  " +
            "FROM job JOIN `publisher` ON job.u_id = publisher.u_id " +
            "WHERE j_id IN" +
            "(SELECT j_id FROM record WHERE u_id = #{u_id})")
    List<Job_Publisher> selectRecord(Integer uId);

    @Select("SELECT j_id,j_name,j_description,j_salary,j_hours,j_require,j_status,p_name  " +
            "FROM job JOIN `publisher` ON job.u_id = publisher.u_id " +
            "WHERE j_id IN " +
            "(SELECT j_id FROM record WHERE u_id = #{u_id} and j_id = #{j_id})")
    Job_Publisher isRecord(@Param("u_id") Integer uId, @Param("j_id") Integer jId);

    @Delete("delete from record where u_id = #{u_id} and j_id = #{j_id}")
    int removeRecord(@Param("u_id") Integer uId, @Param("j_id") Integer jId);


}
