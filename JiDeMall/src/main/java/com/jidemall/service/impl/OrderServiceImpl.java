package com.jidemall.service.impl;

import com.jidemall.entity.Order;
import com.jidemall.entity.Product;
import com.jidemall.entity.User;
import com.jidemall.mapper.OrderMapper;
import com.jidemall.mapper.ProductMapper;
import com.jidemall.mapper.UserMapper;
import com.jidemall.service.OrderService;
import com.jidemall.service.exception.ServiceException;
import com.jidemall.service.exception.UpdateException;
import com.jidemall.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public void order_determine(Order order) {
        User result = userMapper.findByUid(order.getUserId());
        if (result==null||result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在！");
        }

        Product product = productMapper.findProductById(order.getProductId());
//        Product product = products.get(0);
        if (result.getBalance().compareTo(product.getPrice().multiply(BigDecimal.valueOf(order.getAmount()))) == -1){
            throw new ServiceException("用户余额不足！");
        }

        // 修改商品的销量
        product.setSalesCount(product.getSalesCount()+order.getAmount());
        productMapper.updateProduct(product);

        // 添加订单
        Date date = new Date();
        order.setCreateTime(date);
        order.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(order.getAmount())));
        orderMapper.insertOrder(order);

        // 扣除用户余额
        userMapper.subtractBalance(result.getUid(), product.getPrice().multiply(BigDecimal.valueOf(order.getAmount())));
    }

    @Override
    public List<Order> order_query(Integer uid) {
        List<Order> result = orderMapper.queryOrder(uid);
        return result;
    }


    @Override
    public List<Product> order_query_today() {
        List<Product> products = productMapper.queryToday();
        return products;
    }
}
