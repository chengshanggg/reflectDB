package com.shou.hjn.entity;

import com.shou.hjn.dto.BaseBean;

/**
 * Created by xiaoz on 2017/11/4.
 */
public class User implements BaseBean{

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
