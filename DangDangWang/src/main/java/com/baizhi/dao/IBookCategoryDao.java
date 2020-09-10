package com.baizhi.dao;

import com.baizhi.entity.BookCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookCategoryDao {
    List<BookCategory> selectAll();

    List<BookCategory> selectOneByParentId(Integer parent_id);

    BookCategory selectCategoryName(@Param("pid")Integer pid,@Param("cid") Integer cid);

    BookCategory selecttitleByCategoryId(Integer id);

}
