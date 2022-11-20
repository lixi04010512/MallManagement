package com.jidemall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    //分类id
    private Long categoryId;

    //分类名称
    private String categoryName;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
