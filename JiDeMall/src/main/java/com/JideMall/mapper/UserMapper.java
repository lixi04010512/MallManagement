package com.JideMall.mapper;

import com.JideMall.entity.User;

import java.util.Date;

/**
 * 用户模块持久层接口
 */
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user
     * @return 说影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户
     * @return 找到则返回该用户
     */
    User findByUsername(String username);

    /**
     * 根据用户的UID来修改密码
     * @param uid
     * @return
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据id查找用户
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    Integer updateInfoByUid(User user);

    /**
     * @Param 注解是将参数列表中的参数与映射参数相关联，将其注入到映射参数中
     * 修改用户头像
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(Integer uid,String avatar,String modifiedUser,Date modifiedTime);


}
