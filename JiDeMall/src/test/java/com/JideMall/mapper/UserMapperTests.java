package com.jidemall.mapper;

import com.jidemall.entity.Product;
import com.jidemall.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(1));
    }
}
