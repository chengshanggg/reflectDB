package com.shou.hjn.utils;

import java.sql.*;

/**
 * Created by xiaoz on 2017/11/6.
 */
public class JdbcTool {
    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
        String user = "root";
        String password = "root";

        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 释放资源
     * @param con
     * @param rs
     * @param ps
     */
    public static void closeResource(Connection con, ResultSet rs, PreparedStatement ps){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(Connection con,  PreparedStatement ps){


        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
