package com.yjl.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yujiale
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {


    private Long empId;

    private String empName;
    private Double empSalary;


}
