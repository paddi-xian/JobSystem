package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Integer r_id;
    private Integer s_id;
    private Integer j_id;
    private Date startTime;
    private Date endTime;
    private Date workTime;

}
