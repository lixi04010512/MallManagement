package com.jidemall.service.impl;

import com.jidemall.entity.Admin;
import com.jidemall.mapper.AdminMapper;
import com.jidemall.service.AdminService;
import com.jidemall.service.exception.PasswordNotMatchException;
import com.jidemall.service.exception.UserNotFoundException;
import com.jidemall.service.exception.UsernameDuplicatedException;
import com.jidemall.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        Admin result = adminMapper.findByUsername(username);
        if (result==null){
            throw new UsernameDuplicatedException("用户不存在！");
        }
        String salt=result.getSalt();
        String md5Password = WebUtil.getMD5Password(password, salt);
        if (!md5Password.equals(result.getPassword())){
            throw new PasswordNotMatchException("用户密码错误！");
        }
        if (result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在！");
        }
        Admin admin = new Admin();
        admin.setUid(result.getUid());
        admin.setUsername(result.getUsername());
        admin.setAvatar(result.getAvatar());
        return admin;
    }
}