package com.shou.hjn.dao;

import com.shou.hjn.dto.BaseBean;

import java.util.List;

/**
 * Created by xiaoz on 2017/11/4.
 */
public interface DBDao {
    /**
     * 根据 类的绝对路径名 自动注入结果集
     * @param className 绝对路径名
     * @param args 请求参数
     * @return
     */
    List<BaseBean> getResult(String className,String[] args);
}
