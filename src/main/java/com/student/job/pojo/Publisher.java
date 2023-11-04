package com.student.job.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    private Integer p_id;
    private String p_name;
    private String p_telephone;
    private String p_address;
    private String p_email;
    private String p_introduction;
}
