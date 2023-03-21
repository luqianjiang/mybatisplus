package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陆钱江
 * @create 2022-10-23 15:14
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    /**
     * 测试插入一条数据
     * MyBatis-Plus在实现插入数据时，会默认基于雪花算法的策略生成id
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("lqj");
        user.setAge(21);
        user.setEmail("lqj@oz6.cn");
        int result = userMapper.insert(user);
        System.out.println(result > 0 ? "添加成功！" : "添加失败！");
        System.out.println("受影响的行数为：" + result);
        //1584089403549331458（当前 id 为雪花算法自动生成的id）
        System.out.println("id自动获取" + user.getId());
    }

    /**
     * 测试根据id删除一条数据
     */
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1584089403549331458L);
        System.out.println(result > 0 ? "删除成功！" : "删除失败！");
        System.out.println("受影响的行数为：" + result);
    }
    /**
     * 测试根据Map集合中所设置的条件删除数据
     */
    @Test
    public void testDeleteByMap(){
        //当前演示为根据name和age删除数据
        //执行SQL为：DELETE FROM user WHERE name = ? AND age = ?
        Map<String,Object> map = new HashMap<>();
        map.put("name","Vz");
        map.put("age",21);
        int result = userMapper.deleteByMap(map);
        System.out.println(result > 0 ? "删除成功！" : "删除失败！");
        System.out.println("受影响的行数为：" + result);
    }

    /**
     * 测试通过id批量删除数据
     */
    @Test
    public void testDeleteBatchIds(){
        List<Long> ids = Arrays.asList(1L,2L,3L);
        int result = userMapper.deleteBatchIds(ids);
        System.out.println(result > 0 ? "删除成功！" : "删除失败！");
        System.out.println("受影响的行数为：" + result);
    }

    /**
     * 测试根据id修改用户信息
     */
    @Test
    public void testUpdateById(){
        //执行SQL为： UPDATE user SET name=?, age=?, email=? WHERE id=?
        User user = new User();
        user.setId(4L);
        user.setUserName("VzUpdate");
        user.setAge(18);
        user.setEmail("Vz@sina.com");
        int result = userMapper.updateById(user);
        System.out.println(result > 0 ? "修改成功！" : "修改失败！");
        System.out.println("受影响的行数为：" + result);
    }

    /**
     * 测试根据id查询用户数据
     */
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 根据多个id查询用户数据
     */
    @Test
    public void testSelectBatchIds(){
        //执行SQL为：SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> ids = Arrays.asList(1L,2L,3L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }

    /**
     * 根据Map所设置的条件查询用户
     */
    @Test
    public void testSelectByMap(){
        //执行SQL为：SELECT id,name,age,email FROM user WHERE age = ?
        Map<String,Object> map = new HashMap<>();
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 自定义查询
     */
    @Test
    public void testSelectByMapAndOwner(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }


}
