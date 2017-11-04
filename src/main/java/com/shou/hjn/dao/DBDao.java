package com.shou.hjn.dao;

import com.shou.hjn.dto.BaseBean;

import java.util.List;

/**
 * Created by xiaoz on 2017/11/4.
 */
public interface DBDao {
    List<BaseBean> getResult(String className,String[] args);
}
