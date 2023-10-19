package com.student.job.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String url;
    static String user;
    static  String password;
    static String driver;

    static {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\fstudy\\JobSystem\\src\\main\\resources\\jdbc.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            //注册驱动
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //建立连接
    public  static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/eims?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false",
                    "root","12345");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //关闭连接
    public static void close(ResultSet rs,Statement st,Connection conn){

        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
