package com.jyf.ex.ehcache.dao;


import com.jyf.ex.ehcache.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("select * from users where uuid = #{uuid}")
    User getUserByUuid(String uuid);

    @Insert("insert into users (uuid, name, age) values (#{uuid}, #{name}, #{age})")
    int addUser(User user);

    @Update("update users set uuid = #{uuid}, name = #{name}, age = #{age} where uuid = #{uuid}")
    int updateUser(User user);

    @Delete("delete from users where uuid = #{uuid}")
    void deleteUser(String uuid);
}
