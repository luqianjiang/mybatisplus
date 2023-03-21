package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Product;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 陆钱江
 * @create 2022-10-23 22:20
 */
@SpringBootTest
public class MyBaisPlusPluginsTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

    @Test
    public void testPage(){
        //new Page()中的两个参数分别是当前页码，每页显示数量
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());

    }

    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageVo(page, 20);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);
    }

    @Test
    public void testProduct01(){
        //1.小李获取商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productLi.getPrice());
        System.out.println("小李获取版本号：" + productLi.getVersion()); //0

        //2.小王获取商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王获取的商品价格为：" + productWang.getPrice());
        System.out.println("小王获取版本号：" + productWang.getVersion()); //0

        //3.小李修改商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        System.out.println("小李获取版本号：" + productLi.getVersion()); //1

        //4.小王修改商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if(result == 0){
            //操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        System.out.println("小王获取版本号：" + productWang.getVersion()); // 1


        //5.老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
    }


}
