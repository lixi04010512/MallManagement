package com.jidemall.controller.user;

import com.jidemall.entity.Product;
import com.jidemall.service.CategoryService;
import com.jidemall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user/products")
public class UserProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/productDetails/{id}")
    public ModelAndView findProductById(@PathVariable Long id, ModelAndView mv){
        Product product = productService.findProductById(id);
        String categoryName = categoryService.findName(id);
        mv.addObject("product",product);
        mv.addObject("categoryName",categoryName);
        mv.setViewName("product-view");
        return mv;
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
