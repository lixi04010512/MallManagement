package com.jide.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jide.security.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色DAO接口
 *
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
