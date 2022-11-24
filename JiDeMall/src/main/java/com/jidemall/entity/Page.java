package com.jidemall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    public static final Integer PAGE_SIZE=5;
    //当前页码
    private Integer pageNo = 1;
    //总页码
    private Integer pageTotal;
    //当前页显示数量
    private Integer pageSize=PAGE_SIZE;

    //数据总条数
    private Integer pageTotalCount;

    //当前页的第一条数据
    private Integer startRow;

    //请求路径
    private String path;
}