/**
 * 
 */
package com.fullwish.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/**
 * @author fullwish oyqx 连接服务器,发送客户端数据,以及接受服务器数据
 */
public class ConnUtil {

    /**
     * @author oyqx
     * @param String
     *            user_email 用户名(邮箱,唯一)
     * @param String
     *            user_password 用户密码(MD5加密)
     * @param String
     *            basepath 服务器基本访问路径BASE="http://192.168.2.103:8080";
     * @return JSONObject 由服务器传来的json,构建成JSONObject
     * 
     */
    public static JSONObject searchUser(String user_email, String basepath) {
        String new_path = basepath + "?user_email=" + user_email;
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
     *@author oyqx
     * 
     * @param user
     *            JSONObject
     * @param string
     *            paht
     */
    public static void addUser(JSONObject user, String path) {
        /*
         * String user_email=user.getString("user_email"); String
         * user_password=user.getString("user_password");
         */
        try {
            HttpPost httpRequest = new HttpPost(path);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("user_string", user.toString()));// user_string在服务器设置setter方法接受参数
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequest.setEntity(httpentity);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);
            // System.out.println("connutil:"+user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @author fullwish:更新用户信息
     * @param user_string 组拼string获得的json格式的string
     * @param String
     *            path路径
     * 
     */
    public static void userLogin(String user_string, String path) {//登录方法
        try {
            HttpPost httpRequest = new HttpPost(path);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("user_string", user_string));// user_string在服务器设置setter方法接受参数
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequest.setEntity(httpentity);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(httpRequest);
            // System.out.println("connutil:"+user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * @param JSONObject
     *            user组拼
     * @param String
     *            path 路径
     */
    public static void deleteUserInfo(JSONObject user, String path) {

    }

    /**
     * 读取传入数据流
     * 
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
