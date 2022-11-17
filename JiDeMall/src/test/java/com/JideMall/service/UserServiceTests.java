package com.JideMall.service;

import com.JideMall.entity.User;
import com.JideMall.service.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    UserService userService;
    @Test
    void regist(){
        try {
            User user = new User();
            user.setUsername("456");
            user.setPassword("456");
            userService.regist(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    void login(){
        User login = userService.login("456", "456");
        System.out.println(login);
    }
    @Test
    void updatePassword(){
        userService.changePassword(13,"王五1","123456","123");
    }
    @Test
    void getByUid(){
        User byUid = userService.getByUid(12);
        System.out.println(byUid);
    }
    @Test
    void changeInfo(){
        User user = new User();
        user.setPhone("123456");
        user.setEmail("132@qq.com");
        user.setGender(0);
        userService.changeInfo(11,"1233",user);
    }
    @Test
    void changeAvatar(){
        userService.changeAvatar(1,"/d","test");
    }
}
