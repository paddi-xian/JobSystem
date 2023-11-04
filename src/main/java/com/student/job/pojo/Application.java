package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    private Integer a_id;
    private Integer s_id;
    private Integer j_id;
    private Date a_time;
    private String a_status;

}
