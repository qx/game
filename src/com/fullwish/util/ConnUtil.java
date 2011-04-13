/**
 * 
 */
package com.fullwish.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
     *@author oyqx
     * 
     * @param user
     *            JSONObject
     * @param string
     *            paht
     */
    public static void addUser(JSONObject user, String path) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(PATH.BASE + "/p1_add"
                + "&user_google=abcdefg");
        List nameValuePair = new ArrayList();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject.put("user_google", user.getString("user_google"));
            JSONObject userinfo = null;
            jsonObject.put("user", user.getString("user"));
            // jsonObject2.put("userbean", jsonObject);
            // nameValuePair.add(new BasicNameValuePair("jsonString", jsonObject
            // .toString()));
            nameValuePair.add(new BasicNameValuePair("user_json", jsonObject
                    .toString()));// ���͵���������user
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
            // httpPost.setEntity(new
            // UrlEncodedFormEntity(user.getString("User_google")));
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    /**
     * @param user
     * @param string
     */
    public static void updateUser(JSONObject user, String path) {
        // ��ѯ�Ƿ���
        // û���򷵻�
        // �����,���JSONobject,

    }

    /**
     * @param user
     * @param string
     */
    public static void deleteUserInfo(JSONObject user, String path) {
        // ��ѯ�Ƿ�ǿ�
        // ɾ���û�user_google

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
