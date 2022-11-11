package com.jide.security.rest;

import com.jide.security.domain.SysUser;
import com.jide.security.service.SysUserService;
import com.jide.security.service.dto.SysUserQueryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * api用户信息
 *
 * 增加分页查询接口
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@Api(tags = "用户信息接口")
public class SysUserController {

    private final SysUserService sysUserService;

    @ApiOperation("获取当前登录用户信息")
    @GetMapping()
    public ResponseEntity<Object> getUserInfo() {
        return ResponseEntity.ok(sysUserService.getUserInfo());
    }

    @ApiOperation("根据id获取用户信息")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserInfo(@PathVariable Long id) {
        return ResponseEntity.ok(sysUserService.findById(id));
    }

    @ApiOperation("更新用户信息")
    @PostMapping()
    public ResponseEntity<Object> saveUser(@RequestBody SysUser user) {
        return ResponseEntity.ok(sysUserService.update(user));
    }


    @ApiOperation("根据条件查询返回用户列表")
    @PostMapping("/list")
    public ResponseEntity<Object> getSysUserList(@RequestBody SysUserQueryDto sysUserQueryDto) {
        return ResponseEntity.ok(sysUserService.list(sysUserQueryDto));
    }

    @ApiOperation("根据条件查询返回用户分页列表")
    @PostMapping("/page")
    public ResponseEntity<Object> getSysUserPage(@RequestBody SysUserQueryDto sysUserQueryDto) {
        return ResponseEntity.ok(sysUserService.page(sysUserQueryDto));
    }

    @ApiOperation("批量删除用户")
    @DeleteMapping
    public ResponseEntity<Object> deleteUsers(@RequestBody Set<Long> ids) {
        return ResponseEntity.ok(sysUserService.delete(ids));
    }

    @ApiOperation("获取用户角色")
    @GetMapping("/roles/{userId}")
    public ResponseEntity<Object> getUserRoles(@PathVariable Long userId) {
        return ResponseEntity.ok(sysUserService.getUserRoles(userId));
    }

    @ApiOperation("保存用户角色")
    @PostMapping("/roles/{userId}")
    public ResponseEntity<Object> saveUserRoles(@PathVariable Long userId, @RequestBody Set<Long> ids) {
        return ResponseEntity.ok(sysUserService.saveUserRoles(userId, ids));
    }

    @ApiOperation("获取用户权限")
    @GetMapping("/permission/{userId}")
    public ResponseEntity<Object> getUserPermission(@PathVariable Long userId) {
        return ResponseEntity.ok(sysUserService.getUserPermission(userId));
    }

}
