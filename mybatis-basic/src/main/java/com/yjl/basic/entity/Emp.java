package com.yjl.basic.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yujiale
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "m_emp")
public class Emp {
    @TableId
    private Long empId;
    private String empName;
    private Double empSalary;
}
