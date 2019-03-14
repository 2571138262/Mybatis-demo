package com.damu.listener;

import com.damu.utils.SqlSessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitSqlSessionListener implements ServletContextListener {
    // 上下文对象容器初始化的监听方法
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器加载中...");
        // 初始化SqlSessionFactory对象
        SqlSessionFactoryUtils.initSqlSessionFactory();
    }
    // 上下文对象容器销毁的监听方法
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁中...");
        // 关闭SqlSession对象
        SqlSessionFactoryUtils.close();
    }
}
