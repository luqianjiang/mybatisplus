package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 陆钱江
 * @create 2022-10-24 22:20
 */
@SpringBootTest
public class MyBatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = new User();
        user.setUserName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        System.out.println(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:"+result);
    }
}
