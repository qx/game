/**
 * 
 */
package com.fullwish.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.net.UrlQuerySanitizer;

import com.fullwish.base.User;

/**
 * @author fullwish
 *连接服务器
 */
public class ConnUtil {
    private final static String DEBUG_TAG="ConnUtil";
    private User user;
    /**
     * 获取User
     */
    public static User getUser(String user_google,String basepath) {
     String new_path=basepath+"?User_google="+user_google;
     try {
        URL url = new URL(new_path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(6 * 1000);
        if (conn.getResponseCode() == 200) {
            InputStream inStream = conn.getInputStream();
            byte[] data = readStream(inStream);
            System.out.println(data.toString());
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
        return null;
    }

    /**
     * @param inStream
     * @return
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream ba_outStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buff)) != -1) {
            ba_outStream.write(buff, 0, len);
        }
        ba_outStream.close();
        inStream.close();
        return ba_outStream.toByteArray();

    }

    /**
     * 发送user数据
     */
    public static void setUser(User user,String path) {
      //  DefaultHttpClient httpClient = new DefaultHttpClient();
       // HttpPost httpPost = new HttpPost(path+"&User_google="+user_google); 
/*            if (cookie != null) { 
               // httpClient.setCookieStore(LoginJsonUtil.cookie); 
                List nameValuePair = new ArrayList(2);
                nameValuePair.add(new BasicNameValuePair("uid", 
                        uid)); 
                nameValuePair.add(new BasicNameValuePair("subscriptionslist[pageindex]", 
                        subscriptionslist_pageindex)); 
                nameValuePair.add(new BasicNameValuePair("subscriptionslist[recordlimit]", 
                        subscriptionslist_recordlimit));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
            }*/
        
    }

    /**
     * @param user
     * @param string
     */
    public static void addUser(User user, String path) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @param user
     * @param string
     */
    public static void updateUser(User user, String path) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @param user
     * @param string
     */
    public static void deleteUserInfo(User user, String path) {
        // TODO Auto-generated method stub
        
    }

}
