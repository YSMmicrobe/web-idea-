package com.baizhi.service.impl;

import com.baizhi.dao.IUserDao;
import com.baizhi.entity.User;
import com.baizhi.service.IUserService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements IUserService {

    @Override
    public User selectByEmail(String email) {
        SqlSession session = null;
        User user = null;
        try {
            session = MybatisUtil.getSqlSession();
            IUserDao userDao = session.getMapper(IUserDao.class);
            user = userDao.selectByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return user;
    }

    @Override
    public void insertOne(User user) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IUserDao userDao = session.getMapper(IUserDao.class);
            userDao.insertOne(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Override
    public void updateSta(String email) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IUserDao userDao = session.getMapper(IUserDao.class);
            userDao.updateSta(email);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
