package com.baizhi.service.impl;

import com.baizhi.dao.IAddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.IAddressService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressServiceImpl implements IAddressService {

    @Override
    public List<Address> selectAllNowByUId(Integer uid) {
        SqlSession session = null;
        List<Address> addresses = null;
        try {
            session = MybatisUtil.getSqlSession();
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            addresses = addressDao.selectAllNowByUId(uid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }

        return addresses;
    }

    @Override
    public void insertOne(Address address) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            addressDao.insertOne(address);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Override
    public void updateState(String status,Integer id) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            addressDao.updateState(status,id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
