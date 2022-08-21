package com.yjl.basic.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yujiale
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "m_customer")
public class Customer {

    @TableId
    private long customerId;
    private String customerName;

    /**
     * 体现对多关系
     */
    private List<Order> orderList;


}
