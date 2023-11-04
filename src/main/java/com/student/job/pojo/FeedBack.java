package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack {
    private Integer f_id;
    private Integer s_id;
    private Integer j_id;
    private String f_content;
    private Date f_time;

}
