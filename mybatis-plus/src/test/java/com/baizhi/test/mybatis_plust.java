package com.baizhi.test;

import com.baizhi.dao.IUserDao;
import com.baizhi.entity.UserInfo;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class mybatis_plust {
    @Test
    public void testadd(){
        SqlSession session = MybatisUtil.getSqlSession();
        IUserDao userDao = session.getMapper(IUserDao.class);

        for (UserInfo userInfo : userDao.selectList(null)) {
            System.out.println(userInfo);
        }

    }
}
