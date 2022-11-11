package com.jide.security.service.dto;

import com.jide.security.domain.SysUser;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户分页返回数据
 *
 */

@ApiModel(value = "用户分页数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDto {

    private Integer currentPage;

    private Integer pageSize;

    private Long totalPage;

    private List<SysUser> sysUserList;

}
