package com.jidemall.mapper;

import com.jidemall.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    Integer insertOrder(Order order);
}
