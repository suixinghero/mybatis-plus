package org.xujin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.xujin.entity.User;
import org.xujin.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;


    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setName("zhaoliu");
        user.setAge(38);
        user.setEmail("zhaoliu@qq.com");
        int insert = userMapper.insert(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1244530929402122241L);
        user.setAge(22);
        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLocker(){
        //1.根据id查询用户信息
        User user = userMapper.selectById(1244558308598104065L);
        user.setAge(22);
        //2.修改数据，调用方法实现修改
        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLockerFail(){
        //1.根据id查询用户信息
        User user = userMapper.selectById(1244558308598104065L);
        user.setAge(23);
        user.setVersion(user.getVersion()-1);
        //2.修改数据，调用方法实现修改
        userMapper.updateById(user);
    }

    @Test
    public void testselectByMap(){
        Map<String,Object> user = new HashMap<>();
        user.put("name","lisi");
        user.put("age",22);
        user.put("email","lisi@qq.com");
        List<User> users = userMapper.selectByMap(user);
        users.forEach(System.out::println);
    }

    //使用mp实现分页
    @Test
    public void  testPage(){
        Page<User> page = new Page<>(1,8);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        userIPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void testDeleteById(){
        int i = userMapper.deleteById(1245303713791225857L);
    }
}
