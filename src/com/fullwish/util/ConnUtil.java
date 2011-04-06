/**
 * 
 */
package com.fullwish.util;

import android.net.UrlQuerySanitizer;

import com.fullwish.base.User;

/**
 * @author fullwish
 *连接服务器
 */
public class ConnUtil {
    private static UrlQuerySanitizer urlQuerySanitizer;
    /**
     * 获取User
     */
    public static User getUser(String url1) {
        //http://127.0.0.1:8080/test
        urlQuerySanitizer=new UrlQuerySanitizer(url1);
        return null;
    }

    /**
     * 发送user数据
     */
    public static void setUser(User user,String url2) {
        urlQuerySanitizer=new UrlQuerySanitizer(url2);
        
    }

}
