/**
 * 
 */
package com.fullwish.util;

import android.net.UrlQuerySanitizer;

import com.fullwish.base.User;

/**
 * @author fullwish
 *���ӷ�����
 */
public class ConnUtil {
    private static UrlQuerySanitizer urlQuerySanitizer;
    /**
     * ��ȡUser
     */
    public static User getUser(String url1) {
        //http://127.0.0.1:8080/test
        urlQuerySanitizer=new UrlQuerySanitizer(url1);
        return null;
    }

    /**
     * ����user����
     */
    public static void setUser(User user,String url2) {
        urlQuerySanitizer=new UrlQuerySanitizer(url2);
        
    }

}
