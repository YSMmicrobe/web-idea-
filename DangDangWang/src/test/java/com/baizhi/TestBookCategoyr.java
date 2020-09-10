package com.baizhi;

import com.baizhi.entity.BookCategory;
import com.baizhi.service.IBookCategoryService;
import com.baizhi.service.impl.BookCategoryServiceImpl;
import com.baizhi.util.MailUtil;
import org.junit.Test;

import java.util.List;

public class TestBookCategoyr {
    private IBookCategoryService bookCategoryService = new BookCategoryServiceImpl();

    @Test
    public void testSelectAll(){
        List<BookCategory> bookCategories = bookCategoryService.selectAll();

        bookCategories.forEach(bookCategory -> System.out.println(bookCategory));
    }

    @Test
    public void testSelectOne(){
        List<BookCategory> categories = bookCategoryService.selectOneByParentId(1);

        categories.forEach(System.out::println);
    }

    @Test
    public void testSelectPName(){
        BookCategory bookCategory = bookCategoryService.selectCategoryName(1, null);
        System.out.println(bookCategory);

    }

    @Test
    public void testSelectPTitleById(){
        BookCategory bookCategory = bookCategoryService.selecttitleByCategoryId(1);
        System.out.println(bookCategory);

    }
    @Test
    public void testEmail(){
        MailUtil.sendSimpleMail("574432753@qq.com","测试注册邮件","点我激活账户<a href='http://localhost:8989/DangDangWang/user/register_ok.jsp'>激活</a>\"");
    }

}
