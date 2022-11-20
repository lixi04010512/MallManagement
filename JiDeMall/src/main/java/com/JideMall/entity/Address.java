package com.jidemall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    //地址id
    private Long addressId;

    //关联用户id
    private Long userId;

    //区域
    private String area;

    //楼栋
    private String building;

    //门牌号
    private String houseNumber;

    //收货人
    private String consignee;

    //收货人手机号
    private Long phone;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

}