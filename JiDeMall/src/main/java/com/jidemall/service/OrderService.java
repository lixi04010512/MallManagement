package com.jidemall.service;

import com.jidemall.entity.Order;
import com.jidemall.entity.Product;

import java.util.List;

public interface OrderService {
    void order_determine(Order order);
    List<Order> order_query(Integer uid);

    List<Product> order_query_today();
}
