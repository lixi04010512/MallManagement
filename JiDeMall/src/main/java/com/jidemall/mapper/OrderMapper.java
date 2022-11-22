package com.jidemall.mapper;

import com.jidemall.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    Integer insertOrder(Order order);
    List<Order> queryOrder(Integer uid);
}
