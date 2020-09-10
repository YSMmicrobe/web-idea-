package com.baizhi.service;

import com.baizhi.entity.BookCategory;

import java.util.List;

public interface IBookCategoryService {
    List<BookCategory> selectAll();

    List<BookCategory> selectOneByParentId(Integer parent_id);

    BookCategory selectCategoryName(Integer pid,Integer cid);

    BookCategory selecttitleByCategoryId(Integer id);
}
