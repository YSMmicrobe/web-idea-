package com.baizhi.dao;
import com.baizhi.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookDao {
    List<Book> selectMain(@Param("column")String column,@Param("index")Integer index);

    Book selectOne(Integer book_id);

    List<Book> selectAll(@Param("parent_id") Integer parent_id,@Param("category_id")Integer category_id);
}
