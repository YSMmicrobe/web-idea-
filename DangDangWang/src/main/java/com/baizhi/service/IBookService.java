package com.baizhi.service;

import com.baizhi.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectMain(String column,Integer index);

    Book selectOne(Integer book_id);

    List<Book> selectAll(Integer parent_id,Integer category_id,Integer pageNum,Integer pageSize);
}
