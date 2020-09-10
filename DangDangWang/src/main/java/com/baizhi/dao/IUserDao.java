package com.baizhi.dao;

import com.baizhi.entity.User;

public interface IUserDao {
    User selectByEmail(String email);

    void insertOne(User user);

    void updateSta(String email);
}
