package com.student.job.service;

import com.student.job.pojo.Publisher;

public interface PublisherService {
    Publisher getPublisherById(int p_id);
    void insertPublisher(Publisher publisher);
    void updatePublisher(Publisher publisher);
    void deletePublisher(int p_id);
}
