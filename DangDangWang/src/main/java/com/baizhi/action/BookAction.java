package com.baizhi.action;

import com.baizhi.entity.Book;
import com.baizhi.service.IBookCategoryService;
import com.baizhi.service.IBookService;
import com.baizhi.service.impl.BookCategoryServiceImpl;
import com.baizhi.service.impl.BookServiceImpl;

public class BookAction {
    private IBookCategoryService bookCategoryService = new BookCategoryServiceImpl();
    private IBookService bookService = new BookServiceImpl();
    private Integer book_id;
    private Book book;
    public String selectDet(){
        book = bookService.selectOne(book_id);
        return "selectDet";
    }


    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
