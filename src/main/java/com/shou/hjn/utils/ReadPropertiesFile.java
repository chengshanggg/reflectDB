package com.shou.hjn.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by xiaoz on 2017/11/5.
 */
public class ReadPropertiesFile {
    //读取相应的sql文件
    public static void getSqlByName(){
        FileInputStream fileInputStream = null;
        try{
            Properties properties = new Properties();
            fileInputStream = new FileInputStream("sql.properties");
            properties.load(fileInputStream);
            Iterator<String> it = properties.stringPropertyNames().iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getSqlByName();
    }
}
