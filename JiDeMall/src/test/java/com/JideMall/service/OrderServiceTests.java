package com.JideMall.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    OrderService orderService;
    @Test
    void createOrder() {
        Integer[] cids={1,2,3};
        Order tom = orderService.createOrder(8, 14, "tom", cids);
        System.out.println(tom);
    }
}
