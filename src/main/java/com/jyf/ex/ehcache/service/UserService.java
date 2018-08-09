package com.jyf.ex.ehcache.service;

import com.jyf.ex.ehcache.pojo.User;

public interface UserService {

    void deleteUser(String uuid);

    User getUserByUuid(String uuid);

    int addUser(User user);

    int updateUser(User user) throws Exception;

}
