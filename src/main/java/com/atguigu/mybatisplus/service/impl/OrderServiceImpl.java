package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.mapper.OrderMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Order;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.IOrderService;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 陆钱江
 * @create 2022-11-27 19:52
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
