package com.baizhi.service.impl;

import com.baizhi.dao.IBookCategoryDao;
import com.baizhi.entity.BookCategory;
import com.baizhi.service.IBookCategoryService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookCategoryServiceImpl implements IBookCategoryService {

    @Override
    public List<BookCategory> selectAll() {
        SqlSession session = null;
        List<BookCategory> bookCategories = null;
        try {
            session = MybatisUtil.getSqlSession();
            IBookCategoryDao bookCategoryDao = session.getMapper(IBookCategoryDao.class);
            bookCategories = bookCategoryDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }

        return bookCategories;
    }

    @Override
    public List<BookCategory> selectOneByParentId(Integer parent_id) {
        SqlSession session = null;
        List<BookCategory> categories = null;
        try {
            session = MybatisUtil.getSqlSession();
            IBookCategoryDao bookCategoryDao = session.getMapper(IBookCategoryDao.class);
            categories = bookCategoryDao.selectOneByParentId(parent_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }

        return categories;
    }

    @Override
    public BookCategory selectCategoryName(Integer pid, Integer cid) {
        SqlSession session = null;
        BookCategory bookCategory = null;
        try {
            session = MybatisUtil.getSqlSession();
            IBookCategoryDao bookCategoryDao = session.getMapper(IBookCategoryDao.class);
            bookCategory = bookCategoryDao.selectCategoryName(pid, cid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return bookCategory;
    }

    @Override
    public BookCategory selecttitleByCategoryId(Integer id) {
        SqlSession session = null;
        BookCategory bookCategory = null;
        try {
            session = MybatisUtil.getSqlSession();
            IBookCategoryDao bookCategoryDao = session.getMapper(IBookCategoryDao.class);
            bookCategory = bookCategoryDao.selecttitleByCategoryId(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return bookCategory;
    }


}
