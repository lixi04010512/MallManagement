package com.jide.security.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@ApiModel(value = "用户信息")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class SysUser implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String userName;

    @JsonIgnore
    private String password;

    @Email
    private String email;

    @TableLogic
    private Boolean enabled;

    private Timestamp lastPasswordResetTime;

    private Timestamp createTime;

    @Builder.Default
    private Timestamp updateTime = Timestamp.valueOf(LocalDateTime.now());

}
