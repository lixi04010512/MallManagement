package com.jidemall.controller.user;

import com.jidemall.entity.Order;
import com.jidemall.service.OrderService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.jidemall.controller.user.BaseController.OK;

@RestController
@RequestMapping("/users/order")
public class UserOrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("determine")
    public JsonResult<Void> order_determine(Order order, HttpSession session){
        order.setUserId((Integer)session.getAttribute("uid"));
        orderService.order_determine(order);
        return new JsonResult<>(OK);
    }

}
