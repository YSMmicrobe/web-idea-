package com.baizhi.action;

import com.baizhi.entity.Book;
import com.baizhi.entity.BookCategory;
import com.baizhi.service.IBookCategoryService;
import com.baizhi.service.IBookService;
import com.baizhi.service.impl.BookCategoryServiceImpl;
import com.baizhi.service.impl.BookServiceImpl;

import java.util.List;

public class IndexAction {
    private IBookCategoryService bookCategoryService = new BookCategoryServiceImpl();
    private IBookService bookService = new BookServiceImpl();
    private List<BookCategory> bookCategories;
    private List<Book> recommendList;
    private List<Book> hotSaleList;
    private List<Book> newList;
    private List<Book> hotAndNewList;

    public String main(){
        bookCategories = bookCategoryService.selectAll();
        recommendList = bookService.selectMain("salenum",3);
        hotSaleList = bookService.selectMain("salenum desc",9);
        newList = bookService.selectMain("groundingDate",9);
        hotAndNewList = bookService.selectMain("groundingDate desc,salenum desc",9);

        return "main";
    }


    public List<Book> getHotAndNewList() {
        return hotAndNewList;
    }

    public void setHotAndNewList(List<Book> hotAndNewList) {
        this.hotAndNewList = hotAndNewList;
    }

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    public List<Book> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<Book> recommendList) {
        this.recommendList = recommendList;
    }

    public List<Book> getHotSaleList() {
        return hotSaleList;
    }

    public void setHotSaleList(List<Book> hotSaleList) {
        this.hotSaleList = hotSaleList;
    }

    public List<Book> getNewList() {
        return newList;
    }

    public void setNewList(List<Book> newList) {
        this.newList = newList;
    }
}
