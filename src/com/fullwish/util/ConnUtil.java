/**
 * 
 */
package com.fullwish.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * @author fullwish 连接服务器
 */
public class ConnUtil {

    /**
     * 查询用户
     * 
     * @param user_google
     *            用户标识ID
     * @param basepath
     *            路径
     */
    public static JSONObject searchUser(String user_google, String basepath) {
        String new_path = basepath + "?User_google=" + user_google;
        JSONObject jsob = null;
        try {
            URL url = new URL(new_path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6 * 1000);
            if (conn.getResponseCode() == 200) {
                InputStream inStream = conn.getInputStream();
                byte[] data = readStream(inStream);
                String jsonString = new String(data);
                jsob = new JSONObject(jsonString);
                inStream.close();
                conn.disconnect();
            }
        } catch (Exception e) {
        }
        return jsob;
    }

    /**
     * 增加用户
     * 
     * @param user
     *            JSONObject
     * @param string
     *            paht
     */
    public static void addUser(JSONObject user, String path) {
        // 先判断是否有这个用户
        // 没有则写入,
        // 有则返回提示
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(PATH.BASE + "/p1_add"
                + "&User_google=abcdefg");
        /*
         * if (cookie != null) { //
         * httpClient.setCookieStore(LoginJsonUtil.cookie); List nameValuePair =
         * new ArrayList(2); nameValuePair.add(new BasicNameValuePair("uid",
         * uid)); nameValuePair.add(new
         * BasicNameValuePair("subscriptionslist[pageindex]",
         * subscriptionslist_pageindex)); nameValuePair.add(new
         * BasicNameValuePair("subscriptionslist[recordlimit]",
         * subscriptionslist_recordlimit)); httpPost.setEntity(new
         * UrlEncodedFormEntity(nameValuePair)); }
         */

    }

    /**
     * @param user
     * @param string
     */
    public static void updateUser(JSONObject user, String path) {
        // 查询是否有
        // 没有则返回
        // 如果有,更改JSONobject,

    }

    /**
     * @param user
     * @param string
     */
    public static void deleteUserInfo(JSONObject user, String path) {
        // 查询是否非空
        // 删除用户user_google
        
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

}
