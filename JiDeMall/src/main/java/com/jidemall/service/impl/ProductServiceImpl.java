package com.jidemall.service.impl;

import com.jidemall.entity.Page;
import com.jidemall.entity.Product;
import com.jidemall.mapper.ProductMapper;
import com.jidemall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findProductList() {
        List<Product> products = productMapper.findProductList();
        return products;
    }

    @Override
    public Product findProductById(Long productId) {
        Product product = productMapper.findProductById(productId);
        return product;
    }

    @Override
    public List<Product> findProductByName(String productName) {
        List<Product> products = productMapper.findProductByName(productName);
        return products;
    }

    @Override
    public List<Product> findProductByPriceAsc() {
        List<Product> products = productMapper.findProductByPriceAsc();
        return products;
    }

    @Override
    public List<Product> findProductByPriceDesc() {
        List<Product> products = productMapper.findProductByPriceDesc();
        return products;
    }

    @Override
    public Integer deleteProduct(Long productId) {
        Integer count = productMapper.deleteProduct(productId);
        return count;
    }

    @Override
    public Integer insertProduct(Product product) {
        Integer count = productMapper.insertProduct(product);
        return count;
    }

    @Override
    public Integer updateProduct(Product product) {
        Integer count = productMapper.updateProduct(product);
        return count;
    }

    @Override
    public List<Product> salesCountAsc() {
        List<Product> products = productMapper.salesCountAsc();
        return products;
    }

    @Override
    public List<Product> salesCountDesc() {
        List<Product> products = productMapper.salesCountDesc();
        return null;
    }

    @Override
    public Integer getCount() {
        Integer count = productMapper.getCount();
        return count;
    }

    @Override
    public List<Product> productsPaging(Integer startRow,Integer pageSize) {
        List<Product> products = productMapper.productsPaging(startRow,pageSize);
        return products;
    }
}
