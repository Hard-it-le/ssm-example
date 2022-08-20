package com.yjl.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yujiale
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long orderId;
    private String orderName;
    private long customerId;

    /**
     * 体现对一关系
     */
    private Customer customer;
}
