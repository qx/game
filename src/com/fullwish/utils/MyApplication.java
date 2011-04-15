package com.fullwish.utils;

import android.app.Application;

/**
 * 用于获取程序context等内容 manifest配置Application
 * 
 * @author fullwish
 * 
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }
}