package com.jidemall.controller.user;

import com.jidemall.entity.User;
import com.jidemall.service.UserService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("regist")
    public JsonResult<Void> regist(User user){
        userService.regist(user);
        return new JsonResult<>(OK);
    }
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User login = userService.login(username, password);
        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());

        System.out.println("用户id："+getUidFromSession(session)+"密码："+getUsernameFromSession(session));
        return new JsonResult<User>(OK,login);
    }
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<Void>(OK);
    }
    @RequestMapping("getInfo")
    public JsonResult<User> getInfo(HttpSession session){
        User user = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK, user);
    }
    @RequestMapping("changeInfo")
    public JsonResult<Void> changeInfo(HttpSession session,User user){
        userService.changeInfo(getUidFromSession(session),getUsernameFromSession(session),user);
        return new JsonResult<>(OK);
    }
}
