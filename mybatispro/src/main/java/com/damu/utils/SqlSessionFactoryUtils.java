package com.damu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    // 确定Mybatis主配置文件路径
    private static String RESOURCE = "mybatis-config.xml";
    // SQL会话工厂类对象
    private static SqlSessionFactory sqlSessionFactory;
    // 用ThreadLocal存放会话对象(SqlSession)， 保证每个线程中都有一个该变量(会为每个线程创建一个该变量的副本)
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /**
     * 创建一个初始化SqlSessionFactory的方法
     */
    public static void initSqlSessionFactory(){
        try {
            // 通过主配置文件获得其IO流
            InputStream is = Resources.getResourceAsStream(RESOURCE);
            // 创建SqlSessionFactory工厂对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取工厂对象的方法
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 关闭SqlSession的方法
     */
    public static void close(){
        SqlSession session = threadLocal.get();
        if (session != null){
            session.close();
            threadLocal.set(null);
        }
    }
}
