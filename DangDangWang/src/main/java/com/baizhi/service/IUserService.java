package com.baizhi.service;

import com.baizhi.entity.User;

public interface IUserService {
    User selectByEmail(String email);

    void insertOne(User user);

    void updateSta(String email);
}
