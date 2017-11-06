package com.shou.hjn.dao.Impl;

import com.shou.hjn.dao.DBDao;
import com.shou.hjn.dto.BaseBean;
import com.shou.hjn.utils.JdbcTool;
import com.shou.hjn.utils.ReadPropertiesFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.List;

/**
 * Created by xiaoz on 2017/11/4.
 */
public class DBDaoImpl implements DBDao {
    @Autowired
    ReadPropertiesFile readFile;


    @Override
    public List<BaseBean> getResult(String className,String[] args) {
        String[] sqlAndArgs = readFile.getMap().get(className).split(";");
        String sql = sqlAndArgs[0];
        String[] argsType = sqlAndArgs[1].split(",");
        Connection con = null;


        return null;
    }


}
