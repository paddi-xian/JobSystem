package com.student.job.mapper;

import com.student.job.pojo.Publisher;
import com.student.job.pojo.Student;

import java.util.List;

public interface PublisherMapper {
    // 查询所有发布者
    List<Publisher> getAllPublishers();

    // 根据ID查询发布者
    Publisher getPublisherById(Integer u_id);

    // 添加发布者
    int insertPublisher(Publisher publisher);

    // 更新发布者
    void updatePublisher(String p_name, String p_email, String p_telephone, String p_address, String p_introduction);


    // 删除发布者
    void deletePublisherById(Integer p_id);
    List<Student> selectStuByPubUid(Integer u_id);

}
