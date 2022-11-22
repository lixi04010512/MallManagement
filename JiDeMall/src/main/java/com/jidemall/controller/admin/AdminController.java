package com.jidemall.controller.admin;

import com.jidemall.controller.user.BaseController;
import com.jidemall.entity.Admin;
import com.jidemall.service.AdminService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public JsonResult<Admin> login(String username, String password, HttpSession session){
        Admin login = adminService.login(username, password);
        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());

        System.out.println("用户id："+getUidFromSession(session)+"密码："+getUsernameFromSession(session));
        return new JsonResult<Admin>(OK,login);
    }
}