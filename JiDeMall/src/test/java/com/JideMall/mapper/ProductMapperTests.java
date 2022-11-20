package com.jidemall.mapper;

import com.jidemall.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest

public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void findProductList(){
        List<Product> products = productMapper.findProductList();
        System.out.println(products);
    };
}
