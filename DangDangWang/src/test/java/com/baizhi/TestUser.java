package com.baizhi;

import com.baizhi.entity.Book;
import com.baizhi.entity.User;
import com.baizhi.service.IBookService;
import com.baizhi.service.IUserService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.List;

public class TestUser {
    private IUserService userService = new UserServiceImpl();

    @Test
    public void testSelectByEmail(){
        User user = userService.selectByEmail("123@qq.com");
        System.out.println(user);
    }

    @Test
    public void testInsertOne(){
        User user = new User(1,"111@qq.com","王qqqqq","qqqwwweee",1,null);
        userService.insertOne(user);
    }

    @Test
    public void testUpdateSta(){
        userService.updateSta("111@qq.com");
    }
}
