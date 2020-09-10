package com.baizhi.action;

import com.baizhi.entity.Book;
import com.baizhi.entity.BookCategory;
import com.baizhi.service.IBookCategoryService;
import com.baizhi.service.IBookService;
import com.baizhi.service.impl.BookCategoryServiceImpl;
import com.baizhi.service.impl.BookServiceImpl;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class CategoryAction {
    private IBookCategoryService bookCategoryService = new BookCategoryServiceImpl();
    private IBookService bookService = new BookServiceImpl();
    private Integer category_id;
    private Integer parent_id;
    private String parent_category_name;
    private String category_name;
    private String parent_name;
    private BookCategory bookCategory;
    private List<BookCategory> bookCategories;
    private List<Book> books;
    private Integer pageNum = 1;
    private Integer pageSize = 5;
    private PageInfo<Book> pi;

    public String book_list(){
        bookCategories = bookCategoryService.selectOneByParentId(parent_id);
        parent_name = bookCategoryService.selecttitleByCategoryId(parent_id).getCategory_name();
        if (category_id==null){
            books = bookService.selectAll(parent_id,null,pageNum,pageSize);
        }else{
            books = bookService.selectAll(parent_id,category_id,pageNum,pageSize);
            category_name = bookCategoryService.selecttitleByCategoryId(category_id).getCategory_name();
        }
        pi = new PageInfo<>(books);
        return "book_list";
    }


    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageInfo<Book> getPi() {
        return pi;
    }

    public void setPi(PageInfo<Book> pi) {
        this.pi = pi;
    }

    public IBookCategoryService getBookCategoryService() {
        return bookCategoryService;
    }

    public void setBookCategoryService(IBookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public IBookService getBookService() {
        return bookService;
    }

    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    public String getParent_category_name() {
        return parent_category_name;
    }

    public void setParent_category_name(String parent_category_name) {
        this.parent_category_name = parent_category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
