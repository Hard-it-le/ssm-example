package com.yjl.basic.mapper;


import com.yjl.basic.entity.Order;

/**
 * @author yujiale
 */
public interface OrderMapper {

    /**
     * @param orderId
     * @return
     */
    Order selectOrderWithCustomer(Integer orderId);

}
