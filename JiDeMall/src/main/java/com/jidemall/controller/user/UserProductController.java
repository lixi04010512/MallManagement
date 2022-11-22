package com.jidemall.controller.user;

import com.jidemall.entity.Product;
import com.jidemall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/products")
public class UserProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findProductList")
    public List<Product> findProductList(){
        List<Product> products = productService.findProductList();
        return products;
    }

    @GetMapping("/findProductByName/{name}")
    public String findProductByName(@PathVariable String name){
        List<Product> products = productService.findProductByName(name);
        return "success";
    }

    @GetMapping("/findProductByPriceAsc")
    public String findProductByPriceAsc(){
        List<Product> products = productService.findProductByPriceAsc();
        return "success";
    }

    @GetMapping("/findProductByPriceDesc")
    public String findProductByPriceDesc(){
        List<Product> products = productService.findProductByPriceDesc();
        return "success";
    }

    @GetMapping("/salesCountAsc")
    public String salesCountAsc(){
        List<Product> products = productService.salesCountAsc();
        return "success";
    }

    @GetMapping("/salesCountDesc")
    public String salesCountDesc(){
        List<Product> products = productService.salesCountDesc();
        return "success";
    }
}
