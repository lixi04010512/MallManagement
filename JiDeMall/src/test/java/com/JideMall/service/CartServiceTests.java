package com.JideMall.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTests {
    @Autowired
    CartService cartService;
    @Test
    void addToCart(){
        cartService.addToCart(14,10000001,1,"jack");
    }
}
