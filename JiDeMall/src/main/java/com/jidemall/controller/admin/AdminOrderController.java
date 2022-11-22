package com.jidemall.controller.admin;

import com.jidemall.entity.Product;
import com.jidemall.service.OrderService;
import com.jidemall.service.ProductService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

import static com.jidemall.controller.user.BaseController.OK;

@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // 查询历史总营业额
    @RequestMapping("queryHistory")
    public JsonResult<List<Product>> order_query_history(HttpSession session){
        List<Product> res = productService.findProductList();
        for(Product product:res){
            product.setSumPrice(product.getPrice().multiply(BigDecimal.valueOf(product.getSalesCount())));
        }
        return new JsonResult<List<Product>>(OK,res);
    }

    // 查询今日营业额
    @RequestMapping("queryToday")
    public JsonResult<List<Product>> order_query_today(HttpSession session){
        List<Product> res = orderService.order_query_today();

        return new JsonResult<List<Product>>(OK,res);
    }



}
