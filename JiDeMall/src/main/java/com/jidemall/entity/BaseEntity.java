package com.jidemall.entity;

import lombok.*;

import java.util.Date;

//作为实体类的基类
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BaseEntity {
    private String createdUser;

    private Date createdTime;

    private String modifiedUser;

    private Date modifiedTime;
}
