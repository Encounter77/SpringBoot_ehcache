package com.jyf.ex.ehcache.service.impl;

import com.jyf.ex.ehcache.dao.UserDao;
import com.jyf.ex.ehcache.pojo.User;
import com.jyf.ex.ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    //对应ehcache.xml中的缓存策略
    private static final String CACHE_NAME = "users";

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @CacheEvict(value = CACHE_NAME, key = "'user_' + #uuid")
    @Override
    public void deleteUser(String uuid) {
        userDao.deleteUser(uuid);
    }

    @Cacheable(value = CACHE_NAME, key = "'user_' + #uuid")
    @Override
    public User getUserByUuid(String uuid) {
        System.out.println("此处查询了数据库：用户UUID为" + uuid);
        return userDao.getUserByUuid(uuid);
    }


    @CacheEvict(value = CACHE_NAME, key = "'user_' + #user.getUuid()")
    @Override
    public int updateUser(User user) throws Exception {
        User temp = userDao.getUserByUuid(user.getUuid());
        if (null == temp) {
            throw new Exception("未找到待修改对象");
        }
        temp.setName(user.getName());
        temp.setAge(user.getAge());
        return userDao.updateUser(temp);
    }
}
