package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.OrderMapper;
import com.atguigu.mybatisplus.pojo.Order;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.List;

/**
 * @author 陆钱江
 * @create 2022-11-27 19:51
 */
@SpringBootTest
public class MyBatisPlusOrderTest {

    @Resource
    public OrderMapper orderMapper;
    /**
     * 测试插入一条数据
     * MyBatis-Plus在实现插入数据时，会默认基于雪花算法的策略生成id
     */
    @Test
    public void testInsertOrder(){
        Order order=new Order();
        order.setOrderId(4147198);
        order.setCityName("上海");
        order.setToPlace("酒店");
        order.setFromPlace("飞机");
        order.setIsActive(1);
        order.setLocalException(1);
        order.setPrice(50.05);
        int result = orderMapper.insert(order);
        System.out.println(result > 0 ? "添加成功！" : "添加失败！");
        System.out.println("受影响的行数为：" + result);
        System.out.println("id自动获取" + order.getId());
    }

    // 查询订单有效，且是上海的
    @Test
    public void test02(){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isActive",1).eq("cityName","上海");
        List<Order> list = orderMapper.selectList(queryWrapper);
        Order order = orderMapper.selectOne(queryWrapper);
        list.forEach(System.out::println);
        System.out.println(order);
    }

    // 修改订单isActive=1
    @Test
    public void test03(){
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("isActive",1).set("isActive",0);
        int result = orderMapper.update(null, updateWrapper);
        System.out.println(result);
    }

}
