package com.jidemall.controller.admin;

import com.jidemall.entity.Product;
import com.jidemall.service.CategoryService;
import com.jidemall.service.ProductService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findProductList")
    public ModelAndView findProductList(ModelAndView mv) {
        List<Product> products = productService.findProductList();
        mv.addObject("products", products);
        mv.setViewName("table");
        return mv;
    }

    @GetMapping("/findProductById/{id}")
    public ModelAndView findProductById(@PathVariable Long id, ModelAndView mv) {
        Product product = productService.findProductById(id);
        mv.addObject("product", product);
        mv.setViewName("product-view");
        return mv;
    }

    @GetMapping("/findProductByName/{name}")
    public String findProductByName(@PathVariable String name) {
        List<Product> products = productService.findProductByName(name);
        return "success";
    }

    @GetMapping("/findProductByPriceAsc")
    public String findProductByPriceAsc() {
        List<Product> products = productService.findProductByPriceAsc();
        return "success";
    }

    @GetMapping("/findProductByPriceDesc")
    public String findProductByPriceDesc() {
        List<Product> products = productService.findProductByPriceDesc();
        return "success";
    }


    @ResponseBody
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    private final static String FILE_UPLOAD_PATH = "/Users/xi/Desktop/github_project/MallManagement/JiDeMall/src/main/resources/static/img/";

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    @ResponseBody
    public String insertProduct(@RequestParam("file") MultipartFile file,Product product) {
        if (file.isEmpty()) {
            return "上传失败";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        try {
            // 保存文件
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
            System.out.println(path);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer count = productService.insertProduct(product);

        return "redirect:http://localhost:8080/admin/products/table_html";

    }

    @PutMapping("/updateProduct")
    public String updateProduct(Product product) {
        Integer count = productService.updateProduct(product);
        return "success";
    }

    @GetMapping("/table_html")
    public String table_html() {
        return "table";
    }

}
