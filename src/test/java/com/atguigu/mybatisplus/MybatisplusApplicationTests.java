package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser(){
        User user = new User();
        user.setName("zhang333");
        user.setAge(3333);
        user.setEmail("zhang3@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void updateUserById(){
        User user = userMapper.selectById(1435888784091652098L);
        user.setName("zhang333333");
        int update = userMapper.updateById(user);
        System.out.println("update = " + update);
    }

    @Test
    public void findALl() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void getUserById(){
        User user = userMapper.selectById(1435395947864608770L);
        user.setName("wang5");
        int update = userMapper.updateById(user);
        System.out.println("update = " + update);
    }

    @Test
    public void getUserByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void getUserByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","wang5");
        map.put("age",44);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void getUserByPage(){
        Page<User> page = new Page<>(1,2);
        //方式一
        //Page<User> userPage = userMapper.selectPage(page, null);
        //方式二
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void delUserById(){
        int delete = userMapper.deleteById(1435895204933660674L);
        System.out.println("delete = " + delete);
    }

    @Test
    public void getUserByWapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        //（6）select
        wrapper.select("name","age");
        //（7）last

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

}
