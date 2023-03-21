package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陆钱江
 * @create 2022-10-23 16:49
 */
@SpringBootTest
public class MyBatisPlusService {
    @Autowired
    UserService userService;

    @Test
    public void testGetCount(){
        //查询总记录数
        //执行的SQL为：SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    @Test
    public void test(){
        // 批量添加
        // 通过for循环一条一条添加的
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUserName("Vz"+i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b ? "添加成功！" : "添加失败！");
    }
}
