package com.jidemall.service.impl;

import com.jidemall.entity.User;
import com.jidemall.mapper.UserMapper;
import com.jidemall.service.UserService;
import com.jidemall.service.exception.*;
import com.jidemall.util.WebUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void regist(User user) {
        User result = userMapper.findByUsername(user.getUsername());
        if (result != null) {
            throw new UsernameDuplicatedException("用户名已存在！");
        }

        //密码加密:md5算法的形式
        //（串+password+串）---md5算法加密
        //（盐值+password+盐值）---盐值就是随机字符串
        String oldPassword = user.getPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String newPassword = WebUtil.getMD5Password(oldPassword, salt);
        user.setPassword(newPassword);
        //补全数据
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("产生了未知的异常");
        }
    }


    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UsernameDuplicatedException("用户不存在！");
        }
        String salt = result.getSalt();
        String md5Password = WebUtil.getMD5Password(password, salt);
        if (!md5Password.equals(result.getPassword())) {
            throw new PasswordNotMatchException("用户密码错误！");
        }
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在！");
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在！");
        }
        String md5Password = WebUtil.getMD5Password(oldPassword, result.getSalt());
        if (!md5Password.equals(result.getPassword())) {
            throw new PasswordNotMatchException("原密码不正确");
        }
        if (oldPassword.equals(newPassword)) {
            throw new PasswordNotMatchException("修改的密码不可与原密码相同");
        }
        String password = WebUtil.getMD5Password(newPassword, result.getSalt());
        Integer row = userMapper.updatePasswordByUid(uid, password, username, new Date());
        if (row != 1) {
            throw new UpdateException("更新数据产生异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
//        System.out.println(result);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在！");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在！");
        }
        user.setUid(uid);
//        user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer integer = userMapper.updateInfoByUid(user);
        if (integer != 1) {
            throw new UpdateException("更新产生异常！");
        }
    }

    @Autowired
    JavaMailSender jms;
    @Value("${spring.mail.username}")
    private String sender;
    //定义验证码
    private Integer userVerificationCode = null;

    public void sendEmail(String email) {

        Integer userVerificationCode = new Random().nextInt(999999);

        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();

        //发送者
        mainMessage.setFrom(sender);

        //接收者
        mainMessage.setTo(email);

        //发送的标题
        mainMessage.setSubject("邮箱验证");

        //发送的内容
        String msg = "您正在使用邮箱验证，验证码：" + userVerificationCode + "。";
        mainMessage.setText(msg);

        //发送邮件
        jms.send(mainMessage);

        //下面是加入缓存，以便于进行邮箱验证
        this.userVerificationCode = userVerificationCode;

    }

    public boolean test_code(String code) {
        int n = 0;
        n = Integer.parseInt(code);
        if (n == userVerificationCode) {
            return true;
        }
        return false;
    }

}
