package com.shou.hjn.service.impl;

import com.shou.hjn.dao.DBDao;
import com.shou.hjn.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaoz on 2017/11/4.
 */
@Service
public class DBServiceImpl implements DBService {
    @Autowired
    DBDao dbDao;

    @Override
    public Object getResultWithClassName(String className, String[] args) {
        return dbDao.getResult(className,args);
    }
}
