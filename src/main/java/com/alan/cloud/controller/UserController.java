package com.alan.cloud.controller;

import com.alan.cloud.dao.UserRepository;
import com.alan.cloud.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 46512
 * \* Author: Alan
 * \* Date: 2018/12/23 13:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        logger.info("================== findById ID = " + id);
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/list")
    public List<User> getAllUser() {
        logger.info("================== 获取全部的用户信息。");
        List<User> userList = new ArrayList<User>();
        userList = this.userRepository.findAll();
        return userList;
    }
}

