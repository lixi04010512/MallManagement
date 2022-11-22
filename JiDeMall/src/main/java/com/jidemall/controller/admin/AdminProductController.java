package com.jidemall.controller.admin;

import com.jidemall.entity.Product;
import com.jidemall.service.ProductService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findProductList")
    public ModelAndView findProductList(ModelAndView mv){
        List<Product> products = productService.findProductList();
        mv.addObject("products",products);
        mv.setViewName("table");
        return mv;
    }

    @GetMapping("/findProductById/{id}")
    public ModelAndView findProductById(@PathVariable Long id,ModelAndView mv){
        Product product = productService.findProductById(id);
        mv.addObject("product",product);
        mv.setViewName("product-view");
        return mv;
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


    @ResponseBody
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
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

    @GetMapping("/table_html")
    public String table_html(){
        return "table";
    }
}
