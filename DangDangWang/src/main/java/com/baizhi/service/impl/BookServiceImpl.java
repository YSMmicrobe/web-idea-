package com.baizhi.service.impl;

import com.baizhi.dao.IBookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.IBookService;
import com.baizhi.util.MybatisUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookServiceImpl implements IBookService {

    @Override
    public List<Book> selectMain(String column,Integer index) {
        List<Book> books = null;
        SqlSession session = null;
        IBookDao bookDao = null;
        try {
            session = MybatisUtil.getSqlSession();
            bookDao = session.getMapper(IBookDao.class);
            books = bookDao.selectMain(column,index);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return books;
    }

    @Override
    public Book selectOne(Integer book_id) {
        Book book = null;
        SqlSession session = null;
        IBookDao bookDao = null;
        try {
            session = MybatisUtil.getSqlSession();
            bookDao = session.getMapper(IBookDao.class);
            book = bookDao.selectOne(book_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return book;
    }

    @Override
    public List<Book> selectAll(Integer parent_id, Integer category_id,Integer pageNum,Integer pageSize) {
        List<Book> books = null;
        SqlSession session = null;
        IBookDao bookDao = null;
        try {
            session = MybatisUtil.getSqlSession();
            bookDao = session.getMapper(IBookDao.class);
            PageHelper.startPage(pageNum,pageSize);
            books = bookDao.selectAll(parent_id,category_id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return books;
    }
}
