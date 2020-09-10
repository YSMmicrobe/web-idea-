package com.baizhi;

import com.baizhi.entity.Book;
import com.baizhi.service.IBookService;
import com.baizhi.service.impl.BookServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.List;

public class TestBook {
    private IBookService bookService = new BookServiceImpl();

    @Test
    public void testSelectRecommend(){
        List<Book> books = bookService.selectMain("salenum desc",3);
        books.forEach(book -> System.out.println(book));
    }

    @Test
    public void testSelectOne(){
        Book book = bookService.selectOne(1);
        System.out.println(book);

    }
    @Test
    public void testSelectAll(){
        List<Book> books = bookService.selectAll(1,null,1,3);
        PageInfo<Book> pi = new PageInfo<>(books);
        pi.getList().forEach(book -> System.out.println(book));
    }
}
