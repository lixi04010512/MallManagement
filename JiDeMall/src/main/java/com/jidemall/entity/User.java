package com.jidemall.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
    private BigDecimal balance;

}
