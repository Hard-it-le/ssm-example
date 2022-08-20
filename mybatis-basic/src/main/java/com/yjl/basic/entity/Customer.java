package com.yjl.basic.entity;


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
public class Customer {

    private long customerId;
    private String customerName;

    /**
     * 体现对多关系
     */
    private List<Order> orderList;


}
