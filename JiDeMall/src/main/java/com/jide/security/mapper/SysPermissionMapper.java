package com.jide.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jide.security.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限表DAO接口
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
}
