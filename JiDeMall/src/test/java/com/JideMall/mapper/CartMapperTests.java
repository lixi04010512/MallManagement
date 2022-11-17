package com.JideMall.mapper;

import com.xxx.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class CartMapperTests {
    @Autowired
    CartMapper cartMapper;
    @Test
    void insert(){
        Cart cart = new Cart();
        cart.setUid(14);
        cart.setPid(10000001);
        cart.setPrice(1000l);
        cart.setNum(1);
        cartMapper.insert(cart);
    }
    @Test
    void updateNumByCid(){
        cartMapper.updateNumByCid(1,2,"tom",new Date());
    }
    @Test
    void findByUidAndPid(){
        Cart byUidAndPid = cartMapper.findByUidAndPid(14, 10000001);
        System.out.println(byUidAndPid);
    }
    @Test
    void findByCid(){
        Cart byCid = cartMapper.findByCid(1);
        System.out.println(byCid);
    }
    @Test
    void findVOByCid(){
        Integer[] cids={1,2,3,4,89,45};
        System.out.println(cartMapper.findVOByCid(cids));
    }

}
