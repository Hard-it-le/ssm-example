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
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "m_order")
public class Order {

    @TableId
    private long orderId;
    private String orderName;
    private long customerId;

    /**
     * 体现对一关系
     */
    private Customer customer;
}
