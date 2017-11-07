package com.shou.hjn.controller;

import com.shou.hjn.entity.User;
import com.shou.hjn.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoz on 2017/11/4.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    DBService dbService;

    @RequestMapping("/get")
    public Object getUser(@RequestParam("name") String name,
                          @RequestParam("password") String password){
        String[] args = {name,password};
        String className = "com.shou.hjn.entity.User";
        return dbService.getResultWithClassName(className,args);
    }
}
