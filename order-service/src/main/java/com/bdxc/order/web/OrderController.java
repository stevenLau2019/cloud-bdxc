package com.bdxc.order.web;

import com.bdxc.order.mapper.OrderMapper;
import com.bdxc.order.pojo.Order;
import com.bdxc.order.pojo.User;
import com.bdxc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;
   @Autowired
   private OrderMapper orderMapper;

   @Autowired
   private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
//        return orderService.queryOrderById(orderId);
        Order order=orderMapper.findById(orderId);
//        String url="http://localhost:8081/user/"+order.getUserId();
        String url="http://userService/user/"+order.getUserId();

        User user=restTemplate.getForObject(url,User.class);
        order.setUser(user);
        return order;
    }
}
