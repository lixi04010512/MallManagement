package com.jidemall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    //商品id
    private Long productId;

    //分类id
    private Long categoryId;

    //商品名称
    private String productName;

    //商品图片
    private String productImg;

    //简介
    private String intro;

    //详情
    private String details;

    //商品价格
    private BigDecimal price;

    //库存
    private Integer inventory;

    //销量
    private Integer salesCount;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //总销量
    private BigDecimal sumPrice;
}
