package com.jide.security.service;

import com.jide.security.domain.SysPermission;
import com.jide.security.domain.SysRole;
import com.jide.security.service.dto.RoleQueryDto;

import java.util.List;
import java.util.Set;

/**
 * 角色信息接口
 *
 * 增加getPermission，savePermission
 */
public interface SysRoleService {

    /**
     * 增加角色
     *
     * @param role 待新增的角色
     * @return 增加成功的角色
     */
    SysRole create(SysRole role);

    /**
     * 删除角色
     *
     * @param ids 角色id列表
     * @return 是否成功
     */
    Boolean delete(Set<Long> ids);

    /**
     * 修改角色
     *
     * @param role 待修改的角色
     * @return 修改成功的角色
     */
    SysRole update(SysRole role);

    /**
     * 根据角色id查找角色信息
     *
     * @param id 角色id
     * @return 角色信息
     */
    SysRole findById(Long id);

    /**
     * 根据角色代码查找角色
     *
     * @param roleCode 角色代码
     * @return 角色信息
     */
    SysRole findByRoleCode(String roleCode);

    /**
     * 根据角色名称查找角色
     *
     * @param roleName 角色名称
     * @return 角色信息
     */
    SysRole findByRoleName(String roleName);

    /**
     * 获取全部角色信息
     * @return 角色列表
     */
    List<SysRole> findAll();

    /**
     * 根据条件查询角色
     * @param roleQueryDto 查询条件
     * @return 角色列表
     */
    List<SysRole> list( RoleQueryDto roleQueryDto);

    /**
     * 获取角色权限
     *
     * @param roleId 角色id
     * @return 角色权限列表
     */
    List<SysPermission> getPermission(Long roleId);

    /**
     * 保存角色权限
     *
     * @param roleId 角色id
     * @param menus 权限表
     * @return 是否成功
     */
    Boolean savePermission(Long roleId,Set<Long> menus);

}
