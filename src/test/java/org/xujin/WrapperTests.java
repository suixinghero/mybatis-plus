package org.xujin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xujin.entity.User;
import org.xujin.mapper.UserMapper;

/**
 * @author xujin
 * @package-name org.xujin
 * @createtime 2020-04-02 14:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WrapperTests {
    @Autowired
    UserMapper userMapper;
    //1.查询用户年龄大于80岁的
    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    //2.查询用户的名称是jack
    @Test
    public void test02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","jack");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    //3.查询用户的年龄在18-30之间
    @Test
    public void test03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age",18,30);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    //4.模糊查询名称
    @Test
    public void test04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","j");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    //5.按照年龄降序排序
    @Test
    public void test05(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    //6.指定查询的字段
    @Test
    public void test06(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
}