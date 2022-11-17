package com.JideMall.mapper;

import com.xxx.store.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderMapperTests {
    @Autowired
    OrderMapper orderMapper;
    @Test
    void insertOrder(){
        Order order = new Order();
        order.setUid(14);
        order.setRecvName("456");
        order.setRecvPhone("19345231589");
        orderMapper.insertOrder(order);
    }
    @Test
    void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000001);
        orderItem.setTitle("施耐德（Schneider） K15 经典款圆珠笔 (5支混色装)");
        orderMapper.insertOrderItem(orderItem);
    }


}
