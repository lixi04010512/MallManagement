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
    private Integer orderId;

    //用户id
    private Integer userId;

    //收货地址
    private String address;

    //收件人
    private String receiver;

    //收件人电话
    private String phone;

    //商品id
    private Long productId;

    //商品数量
    private Integer amount;

    //订单备注
    private String remark;

    //订单状态
    private String status;

    //确定时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
