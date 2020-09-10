package com.baizhi.service;

import com.baizhi.entity.Address;

import java.util.List;

public interface IAddressService {
    List<Address> selectAllNowByUId(Integer uid);

    void insertOne(Address address);

    void updateState(String status,Integer id);
}
