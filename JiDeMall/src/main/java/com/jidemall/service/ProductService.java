package com.jidemall.service;

import com.jidemall.entity.Page;
import com.jidemall.entity.Product;


import java.util.List;


public interface ProductService{

    //商品列表
    List<Product> findProductList();

    //根据id查询商品
    Product findProductById(Long productId);

    //根据商品名称查找商品
    List<Product> findProductByName(String productName);

    //按价格升序排列商品
    List<Product> findProductByPriceAsc();

    //按价格降序排列商品
    List<Product> findProductByPriceDesc();

    //删除商品
    Integer deleteProduct(Long productId);

    //新增商品
    Integer insertProduct(Product product);

    //修改商品
    Integer updateProduct(Product product);

    //按商品销量升序排列
    List<Product> salesCountAsc();

    //按商品销量降序排列
    List<Product> salesCountDesc();

    //查询商品总数
    Integer getCount();

    //分页查询
    List<Product> productsPaging(Integer startRow,Integer pageSize);
}
