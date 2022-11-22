package com.jidemall.service;

import com.jidemall.entity.Order;

import java.util.List;

public interface OrderService {
    void order_determine(Order order);
    List<Order> order_query(Integer uid);
}
