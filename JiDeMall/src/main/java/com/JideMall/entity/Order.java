package com.jidemall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    //订单id
    private Long orderId;

    //用户id
    private Long userId;

    //收货地址id
    private Long addressId;

    //商品id
    private Long productId;

    //商品数量
    private Integer amount;

    //订单备注
    private String remark;

    //订单状态
    private String status;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
