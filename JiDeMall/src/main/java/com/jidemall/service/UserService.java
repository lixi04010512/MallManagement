package com.jidemall.service;

import com.jidemall.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    /**
     * 用户注册
     * @param user（存储了用户名及用户密码）
     */
    void regist(User user);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 用户密码
     */
    User login(String username,String password);

    /**
     * 修改密码
     * @param uid 用户id
     * @param username 用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * 获取用户电话。邮箱。性别等基本信息
     * @param uid 用户的id
     * @return 查询到的用户
     */
    User getByUid(Integer uid);

    /**
     * 修改用户信息
     * @param uid 用户id
     * @param username 用户名
     * @param user 修改时的信息（封装成了用户对象）
     */
    void changeInfo(Integer uid,String username,User user);


    void sendEmail(String email);

    boolean test_code(String code);

}