package com.JideMall.mapper;

import com.JideMall.util.WebUtil;
import com.JideMall.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
//    @Test
//    void insert(){
//        User user=new User();
//        user.setUsername("test");
//        user.setPassword("test");
//        System.out.println(userMapper.insert(user));
//    }
    @Test
    void findByUsername(){
        User test = userMapper.findByUsername("test");
        System.out.println(test);
    }
    @Test
    void updatePasswordByUid(){
        String asd = WebUtil.getMD5Password("asd", UUID.randomUUID().toString().toUpperCase());
        userMapper.updatePasswordByUid(12,asd,"admin",new Date());
    }
    @Test
    void findByUid(){
        System.out.println(userMapper.findByUid(12));
    }
    @Test
    void updateInfoByUid(){
        User user = new User();
        user.setUid(12);
        user.setPhone("123456789");
        user.setEmail("123@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }
    @Test
    void updateAvatarByUid(){
        userMapper.updateAvatarByUid(1,"/","管理员",new Date());
    }
}
