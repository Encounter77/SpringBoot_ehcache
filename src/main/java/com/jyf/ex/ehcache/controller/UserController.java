package com.jyf.ex.ehcache.controller;

import com.jyf.ex.ehcache.pojo.User;
import com.jyf.ex.ehcache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //定义全局测试用户
    User user = new User(UUID.randomUUID().toString(), "张三", 18);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/ehcache")
    @ResponseBody
    public String ehcache() throws Exception {
        System.out.println("构建测试用户");

        if (userService.addUser(user) == 0) {
            logger.debug("新建用户失败");
            throw new Exception();
        }
        logger.debug("新建用户成功");
        System.out.println(userService.getUserByUuid(user.getUuid()));
        System.out.println(userService.getUserByUuid(user.getUuid()));
        System.out.println(userService.getUserByUuid(user.getUuid()));

        System.out.println("测试修改");
        user.setName("张三改");
        user.setAge(20);
        if (userService.updateUser(user) == 0) {
            logger.debug("修改用户失败");
            throw new Exception();
        }
        logger.debug("修改用户成功");
        System.out.println(userService.getUserByUuid(user.getUuid()));
        System.out.println(userService.getUserByUuid(user.getUuid()));
        System.out.println(userService.getUserByUuid(user.getUuid()));


        System.out.println("测试删除");
        userService.deleteUser(user.getUuid());
        System.out.println(userService.getUserByUuid(user.getUuid()));
        System.out.println(userService.getUserByUuid(user.getUuid()));
        System.out.println(userService.getUserByUuid(user.getUuid()));
        return "测试完毕";
    }

//    @RequestMapping("/ehcache/query")
//    @ResponseBody
//    public String queryUser(){
//        //首次查询
//        System.out.println(userService.getUserByUuid(user.getUuid()));
//        //第二次查询
//        System.out.println(userService.getUserByUuid(user.getUuid()));
//        return "首次查询：" + userService.getUserByUuid(user.getUuid()) +"\n" +
//                "第二次查询";
//    }

}
