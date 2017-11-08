package com.shou.hjn.dao.Impl;

import com.shou.hjn.dao.DBDao;
import com.shou.hjn.dto.BaseBean;
import com.shou.hjn.dto.ClassProperty;
import com.shou.hjn.utils.JdbcTool;
import com.shou.hjn.utils.ReadPropertiesFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoz on 2017/11/4.
 */
@Component
public class DBDaoImpl implements DBDao {
    @Autowired
    ReadPropertiesFile readFile;


    @Override
    public List<BaseBean> getResult(String className,String[] args) {
        readFile.getSqlByName();
        String[] sqlAndArgs = readFile.getMap().get(className).split(";");
        String sql = sqlAndArgs[0];
        String[] argsType = sqlAndArgs[1].split(",");

        // TODO: 2017/11/7 此处不应直接打印，需额外处理
        if(className.trim() == "" || className == null){
            System.out.println("找不到对应的类");
            return new ArrayList<BaseBean>();
        }
        if(sql.trim() == "" || sql == null){
            System.out.println("sql语句不存在");
            return new ArrayList<BaseBean>();
        }
        if(args.length != argsType.length){
            System.out.println("参数不一致");
            return new ArrayList<BaseBean>();
        }

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<BaseBean> result = new ArrayList<>();
        try {
            connection = JdbcTool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setArgs(preparedStatement,args,argsType);
            resultSet = preparedStatement.executeQuery();

            Class clazz = Class.forName(className);
            List<ClassProperty> classPropertys = getProperty(clazz);
            result = setResult(classPropertys,resultSet,clazz);
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            JdbcTool.closeResource(connection,resultSet,preparedStatement);
        }

        return result;
    }

    private List<BaseBean> setResult(List<ClassProperty> classPropertys, ResultSet resultSet, Class clazz) {
        List<BaseBean> lists = new ArrayList<>();
        try{
            while (resultSet.next()){
                BaseBean bean = (BaseBean) clazz.newInstance();
                for(ClassProperty op : classPropertys){
                    Field f = clazz.getDeclaredField(op.getName());
                    String type = op.getType();

                    if("class java.lang.String".equals(type)){
                        String var = resultSet.getString(op.getName());
                        f.setAccessible(true);
                        f.set(bean,var);
                    }
                    if("class java.lang.Integer".equals(type)){
                        Integer var = resultSet.getInt(op.getName());
                        f.setAccessible(true);
                        f.set(bean,var);
                    }
                    //可根据应用继续添加
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获得对应类的属性集
     * @param clazz 对应的类
     * @return 属性列表
     */
    private List<ClassProperty> getProperty(Class clazz) {
        List<ClassProperty> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            ClassProperty op = new ClassProperty();
            Field f = fields[i];
            op.setName(f.getName());
            op.setType(f.getType().toString());
            list.add(op);

        }
        return list;
    }

    /**
     * sql预编译后设置参数
     * @param ps PreparedStatement对象
     * @param args 传入参数
     * @param argsType 参数类型
     */
    private void setArgs(PreparedStatement ps,String[] args,String[] argsType) {
        int index = 1;
        try {

            for (int i = 0; i < argsType.length; i++) {
                if (argsType[i].equalsIgnoreCase("String")) {
                    ps.setString(index++, args[i]);
                }
                if (argsType[i].equalsIgnoreCase("Integer")) {
                    ps.setInt(index++, Integer.valueOf(args[i]));
                }
                //....可根据应用继续扩展

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
