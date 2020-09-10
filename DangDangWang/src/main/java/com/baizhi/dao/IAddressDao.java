package com.baizhi.dao;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAddressDao {
    List<Address> selectAllNowByUId(Integer uid);

    void insertOne(Address address);

    void updateState(@Param("status") String status, @Param("id") Integer id);
}
