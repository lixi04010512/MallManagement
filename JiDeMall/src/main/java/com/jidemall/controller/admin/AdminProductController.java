package com.jidemall.controller.admin;

import com.jidemall.entity.Product;
import com.jidemall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findProductList")
    public String findProductList(){
        List<Product> products = productService.findProductList();
        return "success";
    }

    @GetMapping("/findProductById/{id}")
    public String findProductById(@PathVariable Long id){
        List<Product> products = productService.findProductById(id);
        return "success";
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

    @DeleteMapping("/deleteProduct/{id}")
    public String findProductByPriceDesc(@PathVariable Long id){
        Integer count = productService.deleteProduct(id);
        return "success";
    }

    @PostMapping("/insertProduct")
    public String insertProduct(Product product){
        Integer count = productService.insertProduct(product);
        return "success";
    }

    @PutMapping("/updateProduct")
    public String updateProduct(Product product){
        Integer count = productService.updateProduct(product);
        return "success";
    }
}
