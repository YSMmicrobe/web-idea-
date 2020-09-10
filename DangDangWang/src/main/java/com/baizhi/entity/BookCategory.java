package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * category_id number(10) primary key,--类别的编号
 *   parent_id number(10),--类别的父级类别编号
 *   category_name varchar2(20) not null--类别的名称
 */
public class BookCategory implements Serializable {
    private Integer category_id;
    private Integer parent_id;
    private String  category_name;
    private List<BookCategory> bookCategories;
    private List<Book> bookList;
    private Integer bookNum;
    private String parent_name;



    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "category_id=" + category_id +
                ", parent_id=" + parent_id +
                ", category_name='" + category_name + '\'' +
                ", bookCategories=" + bookCategories +
                ", bookList=" + bookList +
                ", bookNum=" + bookNum +
                ", parent_name='" + parent_name + '\'' +
                '}';
    }
}
