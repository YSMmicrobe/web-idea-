package com.baizhi.entity;

import java.io.Serializable;

public class BookItem implements Serializable {
    private Book book;
    private int bookNum;

    public BookItem() {
    }

    public BookItem(Book book, int bookNum) {
        this.book = book;
        this.bookNum = bookNum;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "book=" + book +
                ", bookNum=" + bookNum +
                '}';
    }
}
