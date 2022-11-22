package com.jidemall.mapper;

import com.jidemall.entity.Admin;
import com.jidemall.entity.User;

public interface AdminMapper {
    Integer insert(User user);

    Admin findByUsername(String username);

    User findByUid(Integer uid);
}
